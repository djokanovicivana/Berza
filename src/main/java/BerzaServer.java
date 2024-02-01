import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rs.raf.pds.v5.z2.gRPC.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class BerzaServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        BerzaServer.BerzaServiceImpl berzaServiceImpl = new BerzaServer.BerzaServiceImpl();


        Server server = ServerBuilder
                .forPort(8090)
                .addService(berzaServiceImpl).build();

        server.start();

        new Thread(berzaServiceImpl::startSocketServer).start();

        //berzaServiceImpl.sendTcpStockUpdates();


        server.awaitTermination();

    }
    static class BerzaServiceImpl extends BerzaServiceGrpc.BerzaServiceImplBase {
        private final Map<String, Client> registeredClients = new ConcurrentHashMap<>();
        private final Map<String, Socket> connections = new ConcurrentHashMap<>();
        private void startSocketServer() {
            try (ServerSocket serverSocket = new ServerSocket(8888)) {
                System.out.println("Socket server started on port 8888");
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New client connected: " + clientSocket.getInetAddress());
                    new Thread(() -> handleSocketClient(clientSocket)).start();
                    //sendTcpStockUpdates();
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
                    if (stock.getSymbol().equals(symbol)) {
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
                for (int i = 0; i < client.getSharesCount(); i++) {
                    if (client.getShares(i).getSymbol().equals(requestedSymbol)) {
                        shareIndex = i;
                        break;
                    }
                }

                if (shareIndex != -1) {
                    int sharesNumber = client.getShares(shareIndex).getTotalShares();
                    if (sharesNumber >= requestedShares) {
                        int newSharesNumber = sharesNumber - requestedShares;
                        SaleOffer saleOffer = SaleOffer.newBuilder()
                                .setSymbol(requestedSymbol)
                                .setPrice(requestedPrice)
                                .setTotalShares(requestedShares)
                                .build();


                         client.toBuilder()
                                .addSaleOffers(saleOffer)
                                .setShares(shareIndex, client.getShares(shareIndex).toBuilder().setTotalShares(newSharesNumber).build())
                                .build();


                        responseObserver.onNext(SellOrderResponse.newBuilder().setSuccess(true).setMessage("Sell order processed successfully").build());
                        responseObserver.onCompleted();
                    } else {

                        responseObserver.onNext(SellOrderResponse.newBuilder().setSuccess(false).setMessage("Not enough available shares").build());
                        responseObserver.onCompleted();
                    }
                } else {

                    responseObserver.onNext(SellOrderResponse.newBuilder().setSuccess(false).setMessage("Symbol not found").build());
                    responseObserver.onCompleted();
                }
            } else {
               
                responseObserver.onNext(SellOrderResponse.newBuilder().setSuccess(false).setMessage("Client not found").build());
                responseObserver.onCompleted();
            }
        }

    }}


