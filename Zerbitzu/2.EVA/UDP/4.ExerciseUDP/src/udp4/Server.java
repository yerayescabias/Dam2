/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp4;

/**
 *
 * @author Ibai
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum number of clients (N): ");
        int maxClients = scanner.nextInt();
        scanner.close();

        final int port = 12345;
        ExecutorService threadPool = Executors.newFixedThreadPool(maxClients);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            int clientCount = 0;

            while (clientCount < maxClients) {
                Socket clientSocket = serverSocket.accept();
                clientCount++;
                int clientNumber = clientCount;

                System.out.println("Client " + clientNumber + " connected.");
                threadPool.execute(() -> handleClient(clientSocket, clientNumber));
            }

            System.out.println("Max clients reached. No longer accepting new connections.");
            threadPool.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket, int clientNumber) {
        try (
            OutputStream output = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true)
        ) {
            String message = "You are client number " + clientNumber;
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

