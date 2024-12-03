package thirdexercise;

import java.io.*;
import java.net.*;

public class AgeClient {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 12347;

        try {
            Socket socket = new Socket(HOST, PORT);

            // Create input and output streams
            BufferedReader consoleReader = new BufferedReader(
                new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(
                socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

            // Get name from user
            System.out.print("Enter your name: ");
            String name = consoleReader.readLine();
            writer.println(name);

            // Get age from user
            System.out.print("Enter your age: ");
            String age = consoleReader.readLine();
            writer.println(age);

            // Read and print server response
            String response = reader.readLine();
            System.out.println("Server response: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}