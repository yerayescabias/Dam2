package guessingnumber;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        final int port = 2626;
        InetAddress address;
        Socket[] sockets;
        Scanner sc = new Scanner(System.in);
        ServerSocket server = null;

        try {
            address = InetAddress.getLocalHost();
            server = new ServerSocket(port);
            System.out.println("Zerbitzaria harierazi egin da " + address + ":" + port + " portuan.");
            BufferedWriter writer ;

           
            int attenders = 0;
            while (attenders <= 0) {
                try {
                    System.out.println("Zenbat pertsona jolastuko dute?");
                    attenders = Integer.parseInt(sc.nextLine());
                    if (attenders <= 0) {
                        System.out.println("Mesedez, sartu balio positibo bat.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Mesedez, sartu zenbaki oso bat.");
                }
            }

            sockets = new Socket[attenders];
            int connectedClients = 0;

           
            while (connectedClients < attenders) {
                Socket client = server.accept();
                writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                writer.write("Wait please...");
                writer.newLine();
                writer.flush();
                System.out.println("Bezero berri bat konektatu da (" + (connectedClients + 1) + "/" + attenders + ")");
                for (int i = 0; i < sockets.length; i++) {
                    if (sockets[i] == null) {
                        sockets[i] = client;
                        connectedClients++;
                        break;
                    }
                }
            }

            System.out.println("Denak konektatu dira. Jokoa hasten...");

           
            Ranking ranking = new Ranking(attenders);
            for (Socket socket : sockets) {
                if (socket != null) {
                    Guess guess = new Guess(socket, ranking);
                    Thread thread = new Thread(guess);
                    thread.start();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
