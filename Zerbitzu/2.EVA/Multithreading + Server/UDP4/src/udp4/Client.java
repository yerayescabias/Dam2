/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp4;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        final int port = 12345;
        DatagramSocket socket = new DatagramSocket();
        DatagramSocket sockeet = new DatagramSocket();
        byte[] buffer = new byte[1024];
        String respuestaa = "Ye saca disco porfa, deja de jugar al the last of us y vuelve con Kim; gracias.";
        byte[] mensajee = respuestaa.getBytes();
        DatagramPacket respuestisiima = new DatagramPacket(mensajee, mensajee.length, InetAddress.getLocalHost(), port);
        socket.send(respuestisiima); 
        
        DatagramPacket recibir = new DatagramPacket(buffer, buffer.length);
        sockeet.receive(recibir);
        String mensaaje = new String(recibir.getData(),0,recibir.getLength());
        System.out.println(mensaaje);
        
        System.out.println();
        String respuesta = "Ye saca disco porfa, deja de jugar al the last of us y vuelve con Kim; gracias.";
        byte[] mensaje = respuesta.getBytes();

        DatagramPacket respuestisima = new DatagramPacket(mensaje, mensaje.length, InetAddress.getLocalHost(), port);
        socket.send(respuestisima); 

        socket.close();
    }
}
