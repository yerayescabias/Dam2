/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package technical_support;

import java.net.*;

/**
 *
 * @author Administrador
 */
public class ServerTS {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       final int port = 2626;
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            ServerSocket socket = new ServerSocket(port);
            while(true)
            {
                Socket clientSocket = socket.accept();
            }
        } catch (Exception e) {
        }
    }
    
}
