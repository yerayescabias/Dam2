package guessingnumber;

import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Administrador
 */
public class Client {
    

        public static void main(String[] args) {
        int serverPort = 5000;
        String serverAddress = "localhost";

        try (Socket client = new Socket(serverAddress, serverPort);
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                Scanner sc = new Scanner(System.in);) {

            String serverMezua = reader.readLine();
            System.out.println(serverMezua);

            int txanda = -1;
            boolean bukatu = false;
            int zenbakia;
            while (txanda != 0 && bukatu == false) {
                bukatu = Boolean.parseBoolean(reader.readLine());

                txanda = Integer.valueOf(reader.readLine());
                System.out.print(txanda + ". txanda: ");
                zenbakia = sc.nextInt();

                writer.write(String.valueOf(zenbakia));
                writer.newLine();
                writer.flush();

                bukatu = Boolean.parseBoolean(reader.readLine());
                txanda = Integer.valueOf(reader.readLine());
                serverMezua = reader.readLine();
                System.out.println(serverMezua);
            }

            serverMezua = reader.readLine();
            System.out.println(serverMezua);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    


}

