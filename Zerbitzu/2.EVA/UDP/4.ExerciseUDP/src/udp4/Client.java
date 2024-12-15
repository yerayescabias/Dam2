/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp4;

/**
 *
 * @author Ibai
 */
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        final String serverAddress = "localhost";
        final int serverPort = 12345;

        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Read and display the message from the server
            String serverMessage = reader.readLine();
            System.out.println("Message from server: " + serverMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

