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
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

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
      

        // Create stock information for the client
        SaleOffer stock1 = SaleOffer.newBuilder()
                .setSymbol("AAPL")
                .setTotalShares(10)
                .build();
        SaleOffer stock2 = SaleOffer.newBuilder()
                .setSymbol("MSFT")
                .setTotalShares(10)
                .build();


        Client clientInfo = Client.newBuilder()
                .setClientId(clientId)
                .addSaleOffers(stock1)
                .addSaleOffers(stock2)
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

     for(BidOffer offer: bidResponse.getOffersList()){
         System.out.println("Client: "+  offer.getClientId()+
                 ", Company: " + offer.getSymbol()+
                 ", Number of shares: "+ offer.getNumberOfOffers()+
                 ", Price: "+ offer.getPrice());
     };
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
