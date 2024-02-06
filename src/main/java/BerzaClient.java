import com.google.protobuf.Timestamp;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import rs.raf.pds.v5.z2.gRPC.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;


public class BerzaClient extends BerzaServiceGrpc.BerzaServiceImplBase {

    private Client clientInfo;
    private Socket tcpSocket;
    BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub;
    private final ManagedChannel grpcChannel;
    private static final AtomicInteger clientCounter = new AtomicInteger(0);


    public BerzaClient(ManagedChannel channel) {

        blockingStub = BerzaServiceGrpc.newBlockingStub(channel);
        this.clientInfo = generateClientInfo();
        grpcChannel = channel;
        sendUserIdToServer();
    }

    private void sendUserIdToServer() {
        try {
            tcpSocket = new Socket("localhost", 8888);
            PrintWriter writer = new PrintWriter(tcpSocket.getOutputStream(), true);
            writer.println(clientInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Client generateClientInfo() {
        // Generate a unique client ID
        String clientId = UUID.randomUUID().toString();
        String[] companySymbols = {
                "AAPL", "MSFT", "GOOGL", "IBM", "AMZN", "NVDA", "META", "TSLA"
        };

        Random random = new Random();

        // Dobijanje nasumičnog indeksa iz niza
        int randomIndex = random.nextInt(companySymbols.length);
        int randomIndex2 = random.nextInt(companySymbols.length);
        int randomIndex3 = random.nextInt(companySymbols.length);


        // Dobijanje nasumične vrednosti iz niza na osnovu generisanog indeksa
        String randomSymbol = companySymbols[randomIndex];
        String randomSymbol2 = companySymbols[randomIndex2];
        String randomSymbol3 = companySymbols[randomIndex3];
        // Create stock information for the client
        AllShares stock1 = AllShares.newBuilder()
                .setSymbol("AAPL")
                .setTotalShares(150)
                .setPrice(200.0)
                .build();
        AllShares stock2 = AllShares.newBuilder()
                .setSymbol("ADBE")
                .setTotalShares(500)
                .setPrice(100.0)
                .build();
        AllShares stock3 = AllShares.newBuilder()
                .setSymbol("MSFT")
                .setTotalShares(300)
                .setPrice(77.5)
                .build();


        Client clientInfo = Client.newBuilder()
                .setClientId(clientId)
                .addShares(stock1)
                .addShares(stock2)
                .addShares(stock3)
                // Add more stocks as needed
                .build();

        return clientInfo;
    }
    private static void handleUserInput(BerzaClient berzaClient, Scanner scanner) {
        String userInput = scanner.nextLine();

        if(userInput.startsWith("ask")){
            String [] parts=userInput.split(" ",3);
            if(parts.length==3){
                berzaClient.askForOffers(parts[1], parseInt(parts[2]), berzaClient);
            }else{
                System.out.println("Invalid ask format!");
            }
        }
        else if(userInput.startsWith("bid")){
            String[] parts=userInput.split(" ", 3);
            if(parts.length==3){
                berzaClient.bidForOffers(parts[1],parseInt(parts[2]), berzaClient);
            }
            else{
                System.out.println("Invalid bid format!");
            }
        }else if(userInput.startsWith("order sell")){
            String [] parts=userInput.split(" ", 5);
            if(parts.length==5){
                berzaClient.sellOrder(parts[2], parseInt(parts[3]), parseDouble(parts[4]), berzaClient);
            }
            else{
                System.out.println("Invalid order sell format!");
            }
        }else if(userInput.startsWith("order buy")){
            String [] parts=userInput.split(" ", 5);
            if(parts.length==5){
                berzaClient.buyOrder(parts[2], parseInt(parts[3]), parseDouble(parts[4]), berzaClient);
            }else{
                System.out.println("Invalid order buy format!");
            }
        }
        else if(userInput.startsWith("transactions")){
            String[] parts = userInput.split(" ", 3);
            if(parts.length == 3){
                try {
                    LocalDate date = LocalDate.parse(parts[2]);
                   // berzaClient.listTransactions(parts[1], date);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please use 'yyyy-MM-dd'.");
                }
            } else {
                System.out.println("Invalid list transactions format!");
            }
        }else if(userInput.startsWith("subscribe")){
            String [] parts= userInput.split(" ");
            List<String> symbols=new ArrayList<>();
            for(int i=1;i<parts.length;i++){
                symbols.add(parts[i]);
            }
            berzaClient.subscribeForPriceUpdates(symbols, berzaClient);

        }


    }

    private static void registerClient(BerzaClient client) {
        try {
            RegisterResponse registerResponse = client.blockingStub.registerClient(client.clientInfo);
            if (registerResponse.getSuccess()) {
                System.out.println("Client registration successful. Client ID: " + client.clientInfo.getClientId());
            } else {
                System.out.println("Client registration failed.");
            }
        } catch (StatusRuntimeException e) {
            System.out.println("Error registering client: " + e.getStatus());
        }
    }
    private static void askForOffers(String symbol, int numberOfOffers, BerzaClient client){
        AskRequest askRequest=AskRequest.newBuilder().setSymbol(symbol).setNumberOfOffers(numberOfOffers).build();

        AskResponse askResponse=client.blockingStub.ask(askRequest);
        if(askResponse.getOffersCount()==0){
            System.out.println("No matching offers found!");
        }

        for(AskOffer offer: askResponse.getOffersList()){
            System.out.println("Client: "+  offer.getClientId()+
                    ", Company: " + offer.getSymbol()+
                    ", Number of shares: "+ offer.getNumberOfOffers()+
                    ", Price: "+ offer.getPrice());
        };
    }
    private static void bidForOffers(String symbol, int numberOfOffers, BerzaClient client) {
     BidRequest bidRequest=BidRequest.newBuilder().setSymbol(symbol).setNumberOfOffers(numberOfOffers).build();

     BidResponse bidResponse=client.blockingStub.bid(bidRequest);

     if(bidResponse.getOffersCount()==0){
         System.out.println();
     }

     for(BidOffer offer: bidResponse.getOffersList()){
         System.out.println("Client: "+  offer.getClientId()+
                 ", Company: " + offer.getSymbol()+
                 ", Number of shares: "+ offer.getNumberOfOffers()+
                 ", Price: "+ offer.getPrice());
     };
     }
    private static void sellOrder(String symbol, int numberOfShares, double price, BerzaClient client) {
        try {
            SellOrderRequest sellOrderRequest = SellOrderRequest.newBuilder()
                    .setSymbol(symbol)
                    .setClientId(client.clientInfo.getClientId())
                    .setPrice(price)
                    .setNumberOfShares(numberOfShares)
                    .build();
            SellOrderResponse sellOrderResponse = client.blockingStub.sellOrder(sellOrderRequest);
            System.out.print(sellOrderResponse.getMessage());
        } catch (StatusRuntimeException e) {
            System.out.println("Error during sellOrder: " + e.getStatus());
        }
    }
    private static void buyOrder(String symbol, int numberOfShares, double price, BerzaClient client) {
        try {
            BuyOrderRequest buyOrderRequest = BuyOrderRequest.newBuilder()
                    .setSymbol(symbol)
                    .setClientId(client.clientInfo.getClientId())
                    .setPrice(price)
                    .setNumberOfShares(numberOfShares)
                    .build();
            BuyOrderResponse buyOrderResponse = client.blockingStub.buyOrder(buyOrderRequest);
            System.out.print(buyOrderResponse.getMessage());
        } catch (StatusRuntimeException e) {
            System.out.println("Error during buyOrder: " + e.getStatus());
        }
    }
    /*public void listTransactions(String symbol, LocalDate date) {
        try {
            TransactionsRequest request = TransactionsRequest.newBuilder()
                    .setSymbol(symbol)
                    .setTimestamp(Timestamp.newBuilder().setSeconds(date.toEpochSecond(ZoneOffset.UTC)).build())
                    .build();

            TransactionsResponse response = blockingStub.transactionsList(request);
            if(response.getTransactionsList().isEmpty()){
                System.out.println("No transactions found for that date!");
            }else{

            for (Transaction transaction : response.getTransactionsList()) {
                System.out.println("Symbol: " + transaction.getSymbol());
                System.out.println("Price: " + transaction.getPrice());
                System.out.println("Number of Shares: " + transaction.getNumberOfShares());
                System.out.println("Buyer Client ID: " + transaction.getBuyerClientId());
                System.out.println("Seller Client ID: " + transaction.getSellerClientId());
                System.out.println("---------------------");
            }}
        } catch (StatusRuntimeException e) {
            System.out.println("Error during listTransactions: " + e.getStatus());
        }
    }


*/
    public void subscribeForPriceUpdates(List<String> symbols, BerzaClient client ) {
        String clientId=client.clientInfo.getClientId();
        SubscribeRequest subscribeRequest = SubscribeRequest.newBuilder()
                .setClientId(clientId)
                .addAllSymbols(symbols)
                .build();

        SubscribeResponse subscribeResponse = client.blockingStub.priceUpdates(subscribeRequest);

        if (subscribeResponse.getSuccess()) {
            System.out.println(subscribeResponse.getMessage());
        } else {
            System.out.println("Failed to subscribe: " + subscribeResponse.getMessage());
        }
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090)
                .usePlaintext()
                .build();
        BerzaClient client = new BerzaClient(channel);
//        BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub = BerzaServiceGrpc.newBlockingStub(channel);
//        BerzaServiceGrpc.BerzaServiceStub asyncStub = BerzaServiceGrpc.newStub(channel);


        registerClient(client);

        try (Socket socket = new Socket("localhost", 8888)) {
            System.out.println("Client connected.");


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String userId = client.clientInfo.getClientId();
            writer.println(userId);


            Scanner scanner = new Scanner(System.in);

            Thread serverListener = new Thread(() -> {
                String serverMessage;
                try {
                    while ((serverMessage = in.readLine()) != null) {

                        System.out.println(serverMessage);


                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
            serverListener.start();

            Thread grpcThread = new Thread(() -> {
                while (true) {
                    handleUserInput(client, scanner);
                }
            });

            grpcThread.start();

            try {
                grpcThread.join();
                serverListener.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


        channel.shutdown();
    }





}
