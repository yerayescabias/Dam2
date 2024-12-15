/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pitagoras;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class ClientPitagoras {

    public static void main(String[] args) {
        final int port = 2626;
        Scanner sc = new Scanner(System.in);
        float firstnumber = 0;
        float secondnumber = 0;

        try {
            DatagramSocket socket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            while (firstnumber == 0 && secondnumber == 0) {
                System.out.println("Enter the first number: ");
                try {
                    firstnumber = sc.nextFloat();
                } catch (Exception e) {
                    System.out.println("Remeber the format ex:2,5 and not equal 0");
                    sc.nextLine();
                }

                System.out.println("Enter the second number: ");
                try {
                    secondnumber = sc.nextFloat();
                } catch (Exception e) {
                    System.out.println("Remeber the format ex:2,5 and not equal 0");
                    sc.nextLine();
                }

            }
            String firstNumberStr = String.valueOf(firstnumber);
            String secondNumberStr = String.valueOf(secondnumber);
            DatagramPacket packet1 = new DatagramPacket(firstNumberStr.getBytes(), firstNumberStr.length(), serverAddress, port);
            DatagramPacket packet2 = new DatagramPacket(secondNumberStr.getBytes(), secondNumberStr.length(), serverAddress, port);

            socket.send(packet1);
            socket.send(packet2);

            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);

            String serverResponse = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println(" The solution is " + serverResponse);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
