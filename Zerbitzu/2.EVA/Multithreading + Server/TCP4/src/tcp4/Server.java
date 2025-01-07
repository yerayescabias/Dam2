/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    final static int port = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(port)) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the number of clients: ");
            int clientCount = scan.nextInt();

            for (int j = 1; j <= clientCount; j++) {
                System.out.println("Waiting for client " + j + "...");
                try (Socket clientSocket = server.accept()) {
                    InputStream input = clientSocket.getInputStream();
                    OutputStream output = clientSocket.getOutputStream();

                    // Enviar el número de cliente al cliente conectado
                    DataOutputStream writer = new DataOutputStream(output);
                    writer.writeInt(j);
                    writer.flush();

                    // Leer mensaje del cliente
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Client " + j + " says: " + line);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
