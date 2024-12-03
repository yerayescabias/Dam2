package secondexercise;

import java.io.*;
import java.net.*;

public class ReceiveNumberServer {

    public static void main(String[] args) {

        final int port = 12346;
        final int randomNum = (int) (Math.random() * 10);

        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Server is waiting for a connection on " + localHost.getHostAddress() + ":" + port);

            try (ServerSocket serverSocket = new ServerSocket(port)) {
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected from: " + clientSocket.getInetAddress());

                    try (
                        InputStream inputStream = clientSocket.getInputStream();
                        OutputStream outputStream = clientSocket.getOutputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                        PrintWriter writer = new PrintWriter(outputStream, true)
                    ) {
                        int clientNumber = Integer.parseInt(reader.readLine());
                        System.out.println("Received from client: " + clientNumber);
                        System.out.println("Adding a random number to " + clientNumber + "\nThe number that will be added is: " + randomNum);

                        int addedNums = clientNumber + randomNum;

                        writer.println(addedNums);
                    } catch (IOException | NumberFormatException e) {
                        System.err.println("Error processing client request: " + e.getMessage());
                        e.printStackTrace();
                    }

                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
