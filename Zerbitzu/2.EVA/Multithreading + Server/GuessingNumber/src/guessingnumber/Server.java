/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guessingnumber;

import java.io.*;
import java.net.*;
/**
 *
 * @author Administrador
 */
public class Server {
    public static void main(String[] args) throws Exception {
        final int port = 5000;
        InetAddress address = InetAddress.getByName("localhost");

        ServerSocket server = new ServerSocket(port);
        System.out.println("Zerbitzaria harierazi egin da " + address + ":" + port + " portuan.");

        try {
            Guess guess;
            Thread thread;

            while (true) {
                Socket client = server.accept();
                System.out.println("Bezero berri bat konektatu da.");

                guess = new Guess(client);
                thread = new Thread(guess);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        server.close();
    }

}
