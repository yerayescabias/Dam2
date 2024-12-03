package fourthexercise;

import java.io.*;
import java.util.*;
import java.net.*;

public class ThreeClientsServer {
    public static void main(String[] args) {
        final int port = 12348;
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("Enter number of clients to connect: ");
        int numClients = userInput.nextInt();
        
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Server is waiting for connections on " 
                + localHost.getHostAddress() + ":" + port);
            ServerSocket serverSocket = new ServerSocket(port);
            
            for (int i = 0; i < numClients; i++) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client " + (i) + " connected from: " 
                    + clientSocket.getInetAddress());
              
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();
              
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream));
                PrintWriter writer = new PrintWriter(outputStream, true); 
              
                String clientMessage = reader.readLine();
                System.out.println("Received from client " + (i) + ": " + clientMessage);
              
                writer.println("You are client number " + (i));
              
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
