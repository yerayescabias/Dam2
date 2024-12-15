/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homosexual;

import java.io.*;
import java.net.*;

/**
 *
 * @author Administrador
 */
public class Activp {
    public static void main(String[] args) throws UnknownHostException {
       final int port = 2626;
       InetAddress inet =InetAddress.getLocalHost();
        try(Socket client = new Socket(inet,port)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            
            String line = reader.readLine();
            System.out.println(line);
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
