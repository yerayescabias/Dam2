/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetospasar;

import java.io.*;
import java.net.*;
import java.util.Random;
/**
 *
 * @author Administrador
 */
public class TCPServer {
    final static int port = 2626;
    final static Random random = new Random();
    public static void main(String[] args) throws UnknownHostException, IOException {
        InetAddress ip = InetAddress.getLocalHost();
        ServerSocket server = new ServerSocket(port);
        System.out.println("Client is connected to the Server");
        try {
            Socket client = server.accept();
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();
            
            ObjectInputStream obj = new ObjectInputStream(input); 
            Student object = (Student)obj.readObject();
            System.out.println(object.toString()+" is the object received from the client");
            object.setId(random.nextInt(0,90));
            
            ObjectOutputStream outputs = new ObjectOutputStream(output);
            outputs.writeObject(object);
            output.flush();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
