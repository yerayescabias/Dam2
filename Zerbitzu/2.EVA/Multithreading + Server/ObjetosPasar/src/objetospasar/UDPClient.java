/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetospasar;

import java.net.*;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.*;

/**
 *
 * @author Administrador
 */

public class UDPClient {
    final static int port = 2626;
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, ClassNotFoundException {
        InetAddress ip = InetAddress.getLocalHost();
        DatagramSocket server = new DatagramSocket();
        byte[] buffer = new byte[1024];
        DatagramPacket enviar = new DatagramPacket(buffer, buffer.length,ip,port);
        
        Student instance = new Student (1,"Rutano", "Revilla",26,50000);
        ByteArrayOutputStream datos = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(datos);
        output.writeObject(instance);
        byte[] data = datos.toByteArray();
        server.send(enviar);
        System.out.println(instance.toString());
        
        byte[] recibido = new byte[1024];
        DatagramPacket receive = new DatagramPacket(recibido, recibido.length);
        server.receive(receive);
        ByteArrayInputStream arrayinput = new ByteArrayInputStream(receive.getData());
        try(ObjectInputStream input = new ObjectInputStream(arrayinput)){
            instance = (Student) input.readObject();
        }
        System.out.println(instance.toString());
        
        
    }
}
