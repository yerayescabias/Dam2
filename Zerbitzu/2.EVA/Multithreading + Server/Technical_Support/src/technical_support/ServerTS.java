/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package technical_support;

import java.net.*;
import java.io.*;
/**
 *
 * @author Administrador
 */
public class ServerTS {
    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) {
        final int port = 9090;
        System.out.println("'SocketTCP_Zerbitzaria_Euskarri_Teknikoa' MARTXAN...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket bezeroa = serverSocket.accept();
                System.out.println("Bezero berri bat konektatu da.");
                // Maneja cada cliente en un hilo separado
                Answere answere = new Answere(bezeroa);
                Thread t1 = new Thread(answere);
                t1.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    }
    
}
