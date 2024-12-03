package firstexercise;

import java.io.*;
import java.net.*;

/**
 *
 * @author Ina
 */

public class GreetingClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 12345;
        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to the server.");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            String serverGreeting = in.readLine();
            System.out.println("Server says: " + serverGreeting);
            
            out.println("Ignacio Arrizabalaga");
            
            String serverResponse = in.readLine();
            System.out.println("Server says: " + serverResponse);
            
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}
