/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practical_yeray;

import java.io.*;
import java.net.*;

/**
 *
 * @author Administrador
 */
public class Server {

    public static void main(String[] args) throws UnknownHostException {
        int port = 2626;
        int port2 = 12321;
        InetAddress ip = InetAddress.getLocalHost();

        try (ServerSocket server = new ServerSocket(port); ServerSocket server2 = new ServerSocket(port2);) {
            System.out.println("Server is connect enbled " + server.getLocalPort());
            System.out.println("Server is connect enbled " + server2.getLocalPort());
            Socket kepa = server.accept();
            System.out.println("client enter in the port " + kepa.getLocalPort());
          
            Socket june = server2.accept();
            System.out.println("client enter in the port " + june.getLocalPort());
            
            
                Calculation calculation = new Calculation(kepa,june);
                Thread t1 = new Thread(calculation);
                t1.start(); 
            
           
            
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
}
