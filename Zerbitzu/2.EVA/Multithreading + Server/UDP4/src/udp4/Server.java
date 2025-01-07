/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udp4;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {

    final static int port = 12345;

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, InterruptedException {
        int clientCounter = 1;
        DatagramSocket socket = new DatagramSocket(port);
        byte[] buffer = new byte[1024];

        Scanner in = new Scanner(System.in);
        System.out.print("Número máximo de clientes: ");
        int max = in.nextInt();

        while (clientCounter <= max) {
            DatagramPacket paquete2 = new DatagramPacket(buffer, buffer.length);
            socket.receive(paquete2);
            
            String saludo = "Hola número " + clientCounter;
            byte[] respuesta = saludo.getBytes();

            DatagramPacket paqueteEnviado = new DatagramPacket(respuesta, respuesta.length, InetAddress.getLocalHost(), port);
            socket.send(paqueteEnviado);

            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
            socket.receive(paquete);

            String receivedMessage = new String(paquete.getData(), 0, paquete.getLength());
            System.out.println(receivedMessage + " ha sido enviado del cliente " + clientCounter);

            clientCounter++;
        }

        
    }
}
