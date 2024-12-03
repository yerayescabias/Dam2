package thirdexercise;

import java.io.*;
import java.net.*;

public class AgeServer {
    public static void main(String[] args) {
        final int port = 12347;
        final int Adult = 18;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from: " + clientSocket.getInetAddress());

                // Create input and output streams
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(
                    clientSocket.getOutputStream(), true);

                String name = reader.readLine();
                
                int age = Integer.parseInt(reader.readLine());

                String response;
                if (age >= Adult) {
                    response = name + " who is " + age + " years old, you are of legal age.";
                } else {
                    response = name + " who is " + age + " years old, you are not of legal age.";
                }

                // Send response back to client
                writer.println(response);

                // Close the client connection
                clientSocket.close();
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}