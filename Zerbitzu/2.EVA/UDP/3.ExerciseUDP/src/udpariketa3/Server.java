/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udpariketa3;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author anera
 */
public class Server {
    
     public static void main(String[] args) {
        final int port = 12345;
        int amount = 1;
        String response = "";

        try {
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Server is listening on port " + port);


            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket namePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(namePacket);
                String name = new String(namePacket.getData(), 0, namePacket.getLength());

           
                buffer = new byte[1024]; 
                DatagramPacket agePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(agePacket);
                int age = Integer.parseInt(new String(agePacket.getData(), 0, agePacket.getLength()));

                if (age >= 18) {
                    response = name + " is an adult.";
                } else {
                    response = name + " is a minor.";
                }
                
                byte[] responseData = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length,
                       namePacket.getAddress(), namePacket.getPort());
                socket.send(responsePacket);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
