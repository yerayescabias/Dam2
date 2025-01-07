/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pitagoras2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        int port = 2626;
        InetAddress ip = InetAddress.getLocalHost();
        DatagramSocket sever = new DatagramSocket();
        Scanner in = new Scanner(System.in);
        System.out.print("Primer numero Maquinon: ");
        int n1 = in.nextInt();
        System.out.print("Segundo numero Maquinon: ");
        int n2 = in.nextInt();
        
       
        
        DatagramPacket numero1 = new DatagramPacket(new String(String.valueOf(n1)).getBytes(),new String(String.valueOf(n1)).getBytes().length, ip, port);
        DatagramPacket numero2 = new DatagramPacket(new String(String.valueOf(n2)).getBytes(),new String(String.valueOf(n2)).getBytes().length, ip, port);
        sever.send(numero1);
        sever.send(numero2);
        
        byte[] result= new byte[1024];
        DatagramPacket resultado = new DatagramPacket(result,result.length);
        sever.receive(resultado);
        
        System.out.println(new String(resultado.getData()));
        
    }
     
}
