package objetospasar;
import java.io.*;
import java.net.*;
import java.util.Random;

public class UDPServer {

    private static final int PORT = 2626;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.println("Servidor iniciado en el puerto " + PORT);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(receivePacket);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Deserializar el objeto Student
                try (ObjectInputStream inputStream = new ObjectInputStream(
                        new ByteArrayInputStream(receivePacket.getData(),0,receivePacket.getData().length))) {
                    Student student = (Student) inputStream.readObject();
                    System.out.println("Recibido: " + student);

                    // Asignar un ID aleatorio al estudiante
                    student.setId(RANDOM.nextInt(90));
                    System.out.println("Modificado: " + student);

                    // Serializar y enviar de vuelta el objeto
                    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                    try (ObjectOutputStream outputStream = new ObjectOutputStream(byteStream)) {
                        outputStream.writeObject(student);
                    }

                    byte[] sendData = byteStream.toByteArray();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                    serverSocket.send(sendPacket);
                    System.out.println("Enviado al cliente: " + clientAddress + ":" + clientPort);
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error al procesar el paquete: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (SocketException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
