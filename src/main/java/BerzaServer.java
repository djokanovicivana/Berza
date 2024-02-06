import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rs.raf.pds.v5.z2.gRPC.*;

import javax.swing.text.DateFormatter;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BerzaServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        BerzaServer.BerzaServiceImpl berzaServiceImpl = new BerzaServer.BerzaServiceImpl();


        Server server = ServerBuilder
                .forPort(8090)
                .addService(berzaServiceImpl).build();

        server.start();

        new Thread(berzaServiceImpl::startSocketServer).start();

        berzaServiceImpl.scheduleHourlyPriceUpdates();;


        server.awaitTermination();

    }
    static class BerzaServiceImpl extends BerzaServiceGrpc.BerzaServiceImplBase {
        private final Map<String, Client> registeredClients = new ConcurrentHashMap<>();
        private final Map<String, Socket> connections = new ConcurrentHashMap<>();
        private final List<Transaction> transactionList = new ArrayList<>();
        private final ConcurrentHashMap<String, Company> companies = new ConcurrentHashMap<String, Company>();

        protected BerzaServiceImpl(){
            generateCompanyData();
        }
        protected void generateCompanyData() {
            for (Company c : InitialData.initCompany()) {
                companies.put(c.getSymbol(), c);
            }

            // Dijagnostički ispis svih kompanija sa njihovim simbolima
            System.out.println("Inicijalizovane kompanije:");
            for (Map.Entry<String, Company> entry : companies.entrySet()) {
                String symbol = entry.getKey();
                Company company = entry.getValue();
                System.out.println("Simbol: " + symbol + ", Naziv: " + company.getName());
            }
        }
            private void startSocketServer() {
            try (ServerSocket serverSocket = new ServerSocket(8888)) {
                System.out.println("Socket server started on port 8888");
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New client connected: " + clientSocket.getInetAddress());
                    new Thread(() -> handleSocketClient(clientSocket)).start();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void handleSocketClient(Socket clientSocket) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String userId = reader.readLine();
                connections.put(userId, clientSocket);

                while (true) {
                    if (clientSocket.isClosed()) {
                        System.out.println("Client disconnected: " + clientSocket.getInetAddress() + " User: " + userId);
                        connections.remove(userId);
                        registeredClients.remove(userId);
                        break;
                    }

                    Thread.sleep(1000);
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        public void registerClient(Client request, StreamObserver<RegisterResponse> responseObserver) {
            // Process the client registration and return a response
            boolean registrationSuccess = true;
            registeredClients.put(request.getClientId(), request);
            // Build and send the response
            RegisterResponse response = RegisterResponse.newBuilder()
                    .setSuccess(registrationSuccess)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        public void ask(AskRequest askRequest, StreamObserver<AskResponse> responseObserver){
            AskResponse.Builder askResponseBuilder=AskResponse.newBuilder();
            String symbol = askRequest.getSymbol();
            List<AskOffer> matchingOffers = new ArrayList<>();
            int numberOfOffers = askRequest.getNumberOfOffers();

            for (Map.Entry<String, Client> entry : registeredClients.entrySet()){
                String clientId = entry.getKey();
                Client client = entry.getValue();
                for (SaleOffer stock : client.getSaleOffersList()) {
                    if (stock.getSymbol().equals(symbol) && numberOfOffers<=stock.getTotalShares()) {
                        AskOffer askOffer = AskOffer.newBuilder()
                                .setSymbol(stock.getSymbol())
                                .setPrice(stock.getPrice())
                                .setNumberOfOffers(stock.getTotalShares())
                                .setClientId(clientId)
                                .build();

                        matchingOffers.add(askOffer);
            }


        }

            }
            matchingOffers.sort(Comparator.comparingDouble(askOffer -> askOffer.getPrice() * askOffer.getNumberOfOffers()));
            List<AskOffer> selectedOffers = matchingOffers.stream().limit(numberOfOffers).collect(Collectors.toList());
            askResponseBuilder.addAllOffers(selectedOffers);


            responseObserver.onNext(askResponseBuilder.build());
            responseObserver.onCompleted();


    }
    public void bid(BidRequest bidRequest, StreamObserver<BidResponse> responseObserver){
        BidResponse.Builder bidResponseBuilder=BidResponse.newBuilder();
        String symbol = bidRequest.getSymbol();
        List<BidOffer> matchingOffers = new ArrayList<>();
        int numberOfOffers = bidRequest.getNumberOfOffers();

        for (Map.Entry<String, Client> entry : registeredClients.entrySet()){
            String clientId = entry.getKey();
            Client client = entry.getValue();
            for (BuyOffer offer : client.getBuyOffersList()) {
                if (offer.getSymbol().equals(symbol)) {
                    BidOffer bidOffer = BidOffer.newBuilder()
                            .setSymbol(offer.getSymbol())
                            .setPrice(offer.getPrice())
                            .setNumberOfOffers(offer.getTotalShares())
                            .setClientId(clientId)
                            .build();

                    matchingOffers.add(bidOffer);
                }


            }

        }
        matchingOffers.sort(Comparator.comparingDouble(askOffer -> askOffer.getPrice() * askOffer.getNumberOfOffers()));
        List<BidOffer> selectedOffers = matchingOffers.stream().limit(numberOfOffers).collect(Collectors.toList());
        bidResponseBuilder.addAllOffers(selectedOffers);


        responseObserver.onNext(bidResponseBuilder.build());
        responseObserver.onCompleted();


    }
        public void sellOrder(SellOrderRequest sellOrderRequest, StreamObserver<SellOrderResponse> responseObserver) {
            String clientId = sellOrderRequest.getClientId();
            Client client = registeredClients.get(clientId);

            if (client != null) {
                int requestedShares = sellOrderRequest.getNumberOfShares();
                String requestedSymbol = sellOrderRequest.getSymbol();
                double requestedPrice = sellOrderRequest.getPrice();
                int shareIndex = -1;
                int existingIndex = -1;

                // Pronađi indeks postojećih akcija za traženi simbol
                for (int i = 0; i < client.getSharesCount(); i++) {
                    if (client.getShares(i).getSymbol().equals(requestedSymbol)) {
                        shareIndex = i;
                        break;
                    }
                }

                // Pronađi indeks postojećeg SaleOffer-a za traženi simbol
                for (int i = 0; i < client.getSaleOffersCount(); i++) {
                    if (client.getSaleOffers(i).getSymbol().equals(requestedSymbol)) {
                        existingIndex = i;
                        break;
                    }
                }

                if (shareIndex != -1) {
                    // Ako postoji SaleOffer za traženi simbol
                    if (existingIndex != -1) {
                        int existingShares = client.getSaleOffers(existingIndex).getTotalShares();
                        int newTotalShares = existingShares + requestedShares;

                        if (requestedShares <= client.getShares(shareIndex).getTotalShares()) {
                            // Ako ima dovoljno dostupnih akcija za prodaju
                            Client updatedClient = client.toBuilder()
                                    .setSaleOffers(existingIndex, client.getSaleOffers(existingIndex).toBuilder().setTotalShares(newTotalShares).build())
                                    .build();
                            registeredClients.put(clientId, updatedClient);
                            int newSharesNumber = client.getShares(shareIndex).getTotalShares() - requestedShares;
                            updatedClient = updatedClient.toBuilder()
                                    .setShares(shareIndex, client.getShares(shareIndex).toBuilder().setTotalShares(newSharesNumber).build())
                                    .build();
                            registeredClients.put(clientId, updatedClient);

                            responseObserver.onNext(SellOrderResponse.newBuilder().setSuccess(true).setMessage("Sell order processed successfully").build());
                            responseObserver.onCompleted();
                        } else {
                            // Ako nema dovoljno dostupnih akcija za prodaju
                            responseObserver.onNext(SellOrderResponse.newBuilder().setSuccess(false).setMessage("Not enough available shares").build());
                            responseObserver.onCompleted();
                        }
                    } else {
                        // Ako ne postoji SaleOffer, ažuriraj postojeće akcije i dodaj novi SaleOffer
                        int sharesNumber = client.getShares(shareIndex).getTotalShares();

                        if (sharesNumber >= requestedShares) {
                            int newSharesNumber = sharesNumber - requestedShares;
                            SaleOffer saleOffer = SaleOffer.newBuilder()
                                    .setSymbol(requestedSymbol)
                                    .setPrice(requestedPrice)
                                    .setTotalShares(requestedShares)
                                    .build();

                            Client updatedClient = client.toBuilder()
                                    .addSaleOffers(saleOffer)
                                    .setShares(shareIndex, client.getShares(shareIndex).toBuilder().setTotalShares(newSharesNumber).build())
                                    .build();
                            registeredClients.put(clientId, updatedClient);

                            responseObserver.onNext(SellOrderResponse.newBuilder().setSuccess(true).setMessage("Sell order processed successfully").build());
                            responseObserver.onCompleted();
                        } else {
                            // Ako nema dovoljno dostupnih akcija za prodaju
                            responseObserver.onNext(SellOrderResponse.newBuilder().setSuccess(false).setMessage("Not enough available shares").build());
                            responseObserver.onCompleted();
                        }
                    }
                } else {
                    // Ako ne postoji akcija za traženi simbol
                    responseObserver.onNext(SellOrderResponse.newBuilder().setSuccess(false).setMessage("Symbol not found").build());
                    responseObserver.onCompleted();
                }
            } else {
                // Ako ne postoji klijent
                responseObserver.onNext(SellOrderResponse.newBuilder().setSuccess(false).setMessage("Client not found").build());
                responseObserver.onCompleted();
            }
        }



        public void buyOrder(BuyOrderRequest buyOrderRequest, StreamObserver<BuyOrderResponse> responseObserver) {
            String clientId = buyOrderRequest.getClientId();
            String symbol = buyOrderRequest.getSymbol();
            int numberOfShares = buyOrderRequest.getNumberOfShares();
            double price = buyOrderRequest.getPrice();

            // Pronalazi odgovarajucu ponudu za prodaju
            SaleOffer matchingSaleOffer=null;
            String sellerId=null;
            for (Client client : registeredClients.values()) {
                for (SaleOffer saleOffer : client.getSaleOffersList()) {
                    if (saleOffer.getSymbol().equals(symbol) &&
                            saleOffer.getTotalShares() >= numberOfShares &&
                            saleOffer.getPrice() <= price) {
                        matchingSaleOffer = saleOffer;
                        sellerId = client.getClientId();
                    }}}

            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDate.format(formatter);
            if (matchingSaleOffer != null && sellerId!=null) {

                executeTransaction(clientId,sellerId, matchingSaleOffer, numberOfShares);
                Transaction transaction=Transaction.newBuilder()
                        .setPrice(price)
                                .setNumberOfShares(numberOfShares)
                                        .setSymbol(symbol)
                                                .setBuyerClientId(clientId)
                                                        .setSellerClientId(sellerId)
                        .setTimestamp(formattedDate)
                                                                .build();
                writeToFile(transaction);
                transactionList.add(transaction);
                updateCompanyPrice(symbol, price);

                // Ako je transakcija uspesna, odgovori sa BuyOrderResponse
                responseObserver.onNext(BuyOrderResponse.newBuilder().setSuccess(true).setMessage("You transaction was successfull!").build());
                responseObserver.onCompleted();
            } else {
                // Ako nema odgovarajuce ponude, dodaj nalog za kupovinu u listu aktivnih naloga
                addBuyOrderToPendingList(clientId, buyOrderRequest);

                // Odgovori da nalog za kupovinu nije odmah izvrsen
                responseObserver.onNext(BuyOrderResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("We couldn't find matching offer. Your offer was added to the pending list!")
                        .build());
                responseObserver.onCompleted();
            }
        }


        // Metoda za izvrsenje transakcije
        private void executeTransaction(String buyerClientId, String sellerClientId, SaleOffer saleOffer, int numberOfShares) {
            Client buyerClient = registeredClients.get(buyerClientId);
            Client sellerClient = registeredClients.get(sellerClientId);

            if (buyerClient != null && sellerClient != null) {
                // Ažuriraj broj akcija kod kupca
                int buyerSharesIndex = -1;
                for (int i = 0; i < buyerClient.getSharesCount(); i++) {
                    if (buyerClient.getShares(i).getSymbol().equals(saleOffer.getSymbol())) {
                        buyerSharesIndex = i;
                        break;
                    }
                }

                if (buyerSharesIndex != -1) {
                    int buyerNewSharesNumber = buyerClient.getShares(buyerSharesIndex).getTotalShares() + numberOfShares;
                    buyerClient = buyerClient.toBuilder()
                            .setShares(buyerSharesIndex, buyerClient.getShares(buyerSharesIndex).toBuilder().setTotalShares(buyerNewSharesNumber).build())
                            .build();
                    registeredClients.put(buyerClientId, buyerClient);

                } else {

                    AllShares buyerNewShares = AllShares.newBuilder()
                            .setSymbol(saleOffer.getSymbol())
                            .setTotalShares(numberOfShares)
                            .setPrice(saleOffer.getPrice())
                            .build();
                    buyerClient = buyerClient.toBuilder().addShares(buyerNewShares).build();
                    registeredClients.put(buyerClientId, buyerClient);
                }


                int sellerSharesIndex = -1;
                for (int i = 0; i < sellerClient.getSharesCount(); i++) {
                    if (sellerClient.getSaleOffers(i).getSymbol().equals(saleOffer.getSymbol())) {
                        sellerSharesIndex = i;
                        break;
                    }
                }

                if (sellerSharesIndex != -1) {
                    int sellerNewSharesNumber = sellerClient.getSaleOffers(sellerSharesIndex).getTotalShares() - numberOfShares;
                    sellerClient = sellerClient.toBuilder()
                            .setSaleOffers(sellerSharesIndex, sellerClient.getSaleOffers(sellerSharesIndex).toBuilder()
                                    .setTotalShares(sellerNewSharesNumber).build())
                            .build();
                    registeredClients.put(sellerClientId, sellerClient);
                }
            } else {
                System.out.print("Greska, ne postoji klijent ili simbol");
            }
        }
        public static void writeToFile(Transaction transaction) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true))) {
                // Formatiranje transakcije i upisivanje u fajl
                String formattedTransaction = String.format(
                        "Symbol: %s, Price: %f, Shares: %d, Buyer: %s, Seller: %s%n",
                        transaction.getSymbol(),
                        transaction.getPrice(),
                        transaction.getNumberOfShares(),
                        transaction.getBuyerClientId(),
                        transaction.getSellerClientId()
                );

                writer.write(formattedTransaction);
            } catch (IOException e) {
                e.printStackTrace();

            }
        }




        private void addBuyOrderToPendingList(String buyerClientId, BuyOrderRequest buyOrderRequest) {
            int numberOfSharesToBuy = buyOrderRequest.getNumberOfShares();
            String symbolToBuy = buyOrderRequest.getSymbol();
            double priceToBuy = buyOrderRequest.getPrice();

            Client buyerClient = registeredClients.get(buyerClientId);

            if (buyerClient != null) {

                BuyOffer newBuyOffer = BuyOffer.newBuilder()
                        .setSymbol(symbolToBuy)
                        .setPrice(priceToBuy)
                        .setTotalShares(numberOfSharesToBuy)
                        .build();

               buyerClient=buyerClient.toBuilder().addBuyOffers(newBuyOffer).build();
               registeredClients.put(buyerClientId, buyerClient);

                // Smanji odgovarajući broj akcija iz liste AllShares
                int sharesIndexToRemove = -1;

                for (int i = 0; i < buyerClient.getSharesCount(); i++) {
                    if (buyerClient.getShares(i).getSymbol().equals(symbolToBuy)) {
                        sharesIndexToRemove = i;
                        break;
                    }
                }

                if (sharesIndexToRemove != -1) {
                    int existingSharesNumber = buyerClient.getShares(sharesIndexToRemove).getTotalShares();
                    int newSharesNumber = existingSharesNumber - numberOfSharesToBuy;


                    if (newSharesNumber == 0) {
                        buyerClient= buyerClient.toBuilder().removeShares(sharesIndexToRemove).build();
                        registeredClients.put(buyerClientId,buyerClient);
                    } else {
                        buyerClient= buyerClient.toBuilder()
                                .setShares(sharesIndexToRemove, buyerClient.getShares(sharesIndexToRemove).toBuilder().setTotalShares(newSharesNumber).build())
                                .build();
                       registeredClients.put(buyerClientId, buyerClient);
                    }
                } else {

                }
            } else {

            }
        }
        public void updateCompanyPrice(String symbol, double newPrice) {
            Company company = companies.get(symbol);
            if (company != null) {
                double previousPrice=company.getPrice();
                Company updatedCompany = company.toBuilder().setPrice(newPrice).build();
                companies.put(symbol, updatedCompany);
                System.out.println("Updated price for company " + symbol + " to " + newPrice);
                for (Map.Entry<String, Client> entry : registeredClients.entrySet()) {
                    String clientId = entry.getKey();
                    Client client = entry.getValue();
                    if (client.getSymbolsList().contains(symbol)) {
                        sendNotificationToSubscribers(clientId, symbol, newPrice, previousPrice);
                    }
            }} else {
                System.out.println("Company with symbol " + symbol + " not found.");
            }
        }

        private void sendNotificationToSubscribers(String clientId, String symbol, double newPrice, double previousPrice) {
            Socket clientSocket = connections.get(clientId);
            if (clientSocket != null) {
                try {
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                    // Formatiranje vremena u format dd.MM.yyyy.-hh'h' mm'm'
                    String currentTime = java.time.LocalDateTime.now().toString().replace("T", "-").substring(0, 16);

                    // Pronalaženje prethodne cene i izračunavanje promene
                    Company company = companies.get(symbol);
                    double change = ((newPrice - previousPrice) / previousPrice) * 100;
                    String changeSign = change >= 0 ? "+" : "-";
                    String changeArrow = change >= 0 ? "↑" : "↓";
                    String changeColor = change >= 0 ? "\u001B[32m" : "\u001B[31m";
                    String resetColor = "\u001B[0m";


                    String notification = String.format("Company: %-5s, Time: %s New price: %.2f Change: %s%s %.2f%% %s %.2f%s",
                            symbol,
                            currentTime,
                            newPrice,
                            changeColor,
                            changeSign,
                            Math.abs(change),
                            changeArrow,
                            previousPrice,
                            resetColor);







                    writer.println(notification);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }







        public void priceUpdates(SubscribeRequest request, StreamObserver<SubscribeResponse> responseObserver) {
            String clientId = request.getClientId();
            List<String> symbols = request.getSymbolsList();



                for(Client client: registeredClients.values()){
                    if(client.getClientId().equals(clientId)){
                        Client updatedClient=client.toBuilder().addAllSymbols(symbols).build();
                        registeredClients.put(clientId, updatedClient);
                    }

                }


            SubscribeResponse response = SubscribeResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Subscription successful")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        private void scheduleHourlyPriceUpdates() {
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(() -> {

                sendHourlyPriceUpdates();
            }, 0, 1, TimeUnit.MINUTES);
        }

        private void sendHourlyPriceUpdates() {
            for (Map.Entry<String, Client> entry : registeredClients.entrySet()) {
                String clientId = entry.getKey();
                Client client = entry.getValue();
                for (String symbol : client.getSymbolsList()) {
                    Company company = companies.get(symbol);
                    if (company != null) {
                        double newPrice = company.getPrice();
                        notifySubscribers(clientId, symbol, newPrice);
                    }
                }
            }
        }

        private void notifySubscribers(String clientId, String symbol, double newPrice) {
            Socket clientSocket = connections.get(clientId);
            if (clientSocket != null) {
                try {
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                    // Formatiranje vremena u format dd.MM.yyyy.-hh'h' mm'm'
                    String currentTime = java.time.LocalDateTime.now().toString().replace("T", "-").substring(0, 16);

                    Company company = companies.get(symbol);


                    // Formatiranje obaveštenja
                    String notification = String.format("Symbol: %-5s, Time: %s, Price: %.2f",
                            symbol,
                            currentTime,
                            newPrice);

                    // Slanje obaveštenja korisniku preko TCP
                    writer.println(notification);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        public void transactionsList(TransactionsRequest request, StreamObserver<TransactionsResponse> responseObserver) {
            String symbol = request.getSymbol();
            String date = request.getTimestamp();


            List<Transaction> filteredTransactions = transactionList.stream()
                    .filter(transaction -> transaction.getSymbol().equals(symbol))
                    .filter(transaction -> transaction.getTimestamp().equals(date))
                    .collect(Collectors.toList());

            TransactionsResponse response = TransactionsResponse.newBuilder()
                    .addAllTransactions(filteredTransactions)
                    .build();


            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }




    }}


