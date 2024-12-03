package fourthexercise;

import java.io.*;
import java.net.*;

public class ThreeClients {
     public static void main(String[] args) {
        final int port = 12348;
        
        try {
            Socket socket = new Socket("localhost", port);
            
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            
            PrintWriter writer = new PrintWriter(outputStream, true);
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream));
            
            writer.println("Hello, server!");
            
            String serverResponse = reader.readLine();
            System.out.println("Received from server: " + serverResponse);
            
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
