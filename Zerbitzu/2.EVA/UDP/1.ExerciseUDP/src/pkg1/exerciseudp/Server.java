/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1.exerciseudp;
import java.io.*;
import java.net.*;


/**
 *
 * @author USUARIO
 */
public class Server {
    public static void main(String[] args) {
        final int port = 12345;

        try {
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Server is listening on port " + port);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivedPacket);

                String receivedMessage = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                System.out.println("Received from client: " + receivedMessage);

                // Process the received data, if needed

                // Respond to the client
                String responseMessage = "Hello, client!";
                byte[] responseData = responseMessage.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length,
                        receivedPacket.getAddress(), receivedPacket.getPort());
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
