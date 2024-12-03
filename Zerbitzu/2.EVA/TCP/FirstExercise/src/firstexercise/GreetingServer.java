package firstexercise;

import java.io.*;
import java.net.*;

/**
 *
 * @author Ina
 */

public class GreetingServer {
    public static void main(String[] args) {
        int port = 12345; // You can choose any port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is waiting for a connection...");
            
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connected.");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                
                out.println("Who is this?");
                
                String clientGreeting = in.readLine();
                System.out.println("Client says: " + clientGreeting);

                out.println("Nice to meet you, " + clientGreeting + "!");
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
