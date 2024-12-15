package pitagoras;
import java.io.*;
import java.net.*;

/**
 *
 * @author Administrador
 */
public class ServerPitagoras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int port = 2626;
        try {
            DatagramSocket socket = new DatagramSocket(port);
            byte[] buffer = new byte[1024];
            byte[] buffer2 = new byte[1024];
            System.out.println("Server starts");
            while (true) {
                DatagramPacket firstnumber = new DatagramPacket(buffer, buffer.length);
                DatagramPacket secondnumber = new DatagramPacket(buffer2, buffer2.length);
                socket.receive(firstnumber);
                socket.receive(secondnumber);

                Pitagoras pitagoras = new Pitagoras(firstnumber, secondnumber, socket);
                Thread t1pitagoras = new Thread(pitagoras);
                t1pitagoras.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
