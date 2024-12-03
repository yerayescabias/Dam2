package secondexercise;

import java.io.*;
import java.net.*;

/**
 * Client to send a number to the server and receive the result.
 */
public class SendNumberClient {

    public static void main(String[] args) {
        final int port = 12346;
        final int secretNumber = 6969;

        try {
            // Set up the server address (localhost)
            InetAddress serverAddress = InetAddress.getLocalHost();

            // Connect to the server
            System.out.println("Connecting to server at " + serverAddress.getHostAddress() + ":" + port);

            try (Socket socket = new Socket(serverAddress, port)) {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                PrintWriter writer = new PrintWriter(outputStream, true);

                System.out.println("Sending number to the server: " + secretNumber);

                writer.println(secretNumber);

                String serverResponse = reader.readLine();
                System.out.println("Response from server: My random number + yours sums: " + serverResponse);
            }
        } catch (UnknownHostException e) {
            System.err.println("Error: Unable to resolve host. Ensure the server is running.");
        } catch (IOException e) {
            System.err.println("Error: Unable to connect to the server or communicate properly.");
            e.printStackTrace();
        }
    }
}
