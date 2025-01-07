package exam;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Client {

    public static void main(String[] args) throws UnknownHostException {
        final int port = 2626;
        InetAddress ip = InetAddress.getLocalHost();

        try (Socket client = new Socket(ip, port); BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream())); BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream())); Scanner sc = new Scanner(System.in);) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("para")) {
                    System.out.println("Your answers: ");
                    writer.write(sc.next());
                    writer.newLine();
                    writer.flush();
                } else if (line.equals("seco")) {
                    break;
                } else {
                    System.out.println(line);
                }

            }
           

        } catch (Exception e) {
        }

    }
}
