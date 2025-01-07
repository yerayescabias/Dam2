/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exam;


import java.io.*;
import java.net.*;

/**
 *
 * @author Administrador
 */
public class ClientExam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        final int port = 2626;
        InetAddress inet = InetAddress.getLocalHost();
        try {
            ServerSocket server = new ServerSocket(port);
            while(true)
            {
                Socket customer = server.accept();
                System.out.println("Client connected ");
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(customer.getOutputStream()));
                writer.write("How many students are gonna play? ");
                writer.flush();
            }
        } catch (Exception e) {
        }
    }
    
}
