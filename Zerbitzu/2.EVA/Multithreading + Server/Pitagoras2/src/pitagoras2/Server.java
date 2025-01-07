/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pitagoras2;

import java.net.*;
import java.io.*;

/**
 *
 * @author Administrador
 */
public class Server {
    
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        int port = 2626;
        InetAddress ip = InetAddress.getLocalHost();
        DatagramSocket sever = new DatagramSocket(port);
        byte[] buffer = new byte[1024];
        byte[] buffer2 = new byte[1024];
        
        while(true){
            DatagramPacket n1 = new DatagramPacket(buffer, buffer.length);
            DatagramPacket n2 = new DatagramPacket(buffer2,buffer2.length);
            sever.receive(n1);
            sever.receive(n2);
            
            
            Pitagoras pi = new Pitagoras(n1,n2,sever);
            Thread t1 = new Thread(pi);
            t1.start();
            
            
        }
        
        
    }
}
