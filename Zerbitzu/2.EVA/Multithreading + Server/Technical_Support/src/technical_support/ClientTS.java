package technical_support;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientTS {

    public static void main(String[] args) {
        final String host = "localhost";
        final int port = 9090;

        System.out.println("'SocketTCP_Bezeroa_Euskarri_Teknikoa' MARTXAN...");

        try (Socket socket = new Socket(host, port);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                Scanner scanner = new Scanner(System.in)) {

            // Lee y muestra las preguntas del servidor
            String serverMessage;
            while (!(serverMessage = reader.readLine()).equals("EOF")) {
                System.out.println(serverMessage);
            }

            int aukera;
            do {
                System.out.print("Eskaera: ");
                aukera = scanner.nextInt();

                // Envía la opción al servidor
                writer.write(String.valueOf(aukera));
                writer.newLine();
                writer.flush();

                // Lee la respuesta del servidor
                String respuesta = reader.readLine();
                if (respuesta != null) {
                    System.out.println("Erantzuna: " + respuesta);
                }

                if (aukera == 6) {
                    System.out.println("'SocketTCP_Bezeroa_Euskarri_Teknikoa' ITZALTZEN.");
                    break;
                }
            } while (true);

        } catch (IOException e) {
            System.out.println("Errorea: " + e.getMessage());
        }
    }
}
