/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udpariketa5;


import java.io.*;
import java.net.*;

public class Server {
    private static int studentCounter = 1; 
    
    public static void main(String[] args) {
        final int port = 12345;

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try {
                    byte[] buffer = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

                    socket.receive(receivePacket);
                    System.out.println("Packet received from: " + receivePacket.getAddress());

                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(receivePacket.getData());
                    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    Student student = (Student) objectInputStream.readObject();
                    System.out.println("Received student: " + student);

                    student.setId(studentCounter++);
                    System.out.println("Assigned ID to student: " + student.getId());

                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(student);
                    objectOutputStream.flush();
                    
                    byte[] sendData = byteArrayOutputStream.toByteArray();
                    DatagramPacket sendPacket = new DatagramPacket(
                        sendData,
                        sendData.length,
                        receivePacket.getAddress(),
                        receivePacket.getPort()
                    );
                    
                    socket.send(sendPacket);
                    System.out.println("Sent updated student back to client: " + student);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
