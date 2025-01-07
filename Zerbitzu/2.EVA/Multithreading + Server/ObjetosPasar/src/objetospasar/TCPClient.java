/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetospasar;


import java.net.*;
import java.io.*;

/**
 *
 * @author Administrador
 */
public class TCPClient {
    final static int port = 2626;
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        try (Socket student = new Socket(ip, port)) {
            Student instance = new Student (0,"Rutano", "Revilla",26,50000);
            InputStream input = student.getInputStream();
            OutputStream output = student.getOutputStream();
            
            ObjectOutputStream outputs = new ObjectOutputStream(output);
            outputs.writeObject(instance);
            output.flush();
            System.out.println("Sended to the Server");
            ObjectInputStream obj = new ObjectInputStream(input); 
            Student object = (Student)obj.readObject();
            System.out.println(object.toString());
            
            
        } catch (Exception e) {
        }
    }
}
