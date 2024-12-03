/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1.exerciseudp;

import java.net.*;
import java.io.*;

/**
 *
 * @author USUARIO
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int PORT = 2626;
        try {
            DatagramSocket datagramsocket = new DatagramSocket();
            InetAddress serverAdress = InetAddress.getLocalHost();
            String mssg = "Hello";
            byte[] mssgbyte = mssg.getBytes();

            DatagramPacket packet = new DatagramPacket(mssgbyte, mssgbyte.length, serverAdress, PORT);
            datagramsocket.send(packet);

            //respuesta del server
            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            datagramsocket.receive(responsePacket);

            String serverResponse = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Server says: " + serverResponse);

            // Close the socket when done
            datagramsocket.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
