package udpariketa3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        final int serverPort = 12345;
        try {
            DatagramSocket socket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Give me the name of the User: ");
            String name = scanner.nextLine();
            
            System.out.print("Give me the age of the User: ");
            int age = scanner.nextInt();

            byte[] data = name.getBytes(); 
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);
            
            byte[] data2 = Integer.toString(age).getBytes(); 
            DatagramPacket packet2 = new DatagramPacket(data2, data2.length, serverAddress, serverPort);

            socket.send(packet);
            socket.send(packet2);

            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);

            String serverResponse = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Server says: " + serverResponse);

            scanner.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
