package tcp4;

import java.io.*;
import java.net.*;

/**
 *
 * @author Administrador
 */

public class Client {
    final static int port = 12345;

    public static void main(String[] args) {
        try {
            InetAddress serverAddress = InetAddress.getLocalHost();

            try (Socket cliente = new Socket(serverAddress, port)) {
                InputStream input = cliente.getInputStream();
                OutputStream output = cliente.getOutputStream();

                // Leer un entero enviado por el servidor
                DataInputStream reader = new DataInputStream(input);
                int value = reader.readInt();
                System.out.println("Received from server: " + value);

                // Enviar mensaje al servidor
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                writer.write("Hello from Client " + value + "\n"); // Asegurarse de incluir un salto de línea
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
