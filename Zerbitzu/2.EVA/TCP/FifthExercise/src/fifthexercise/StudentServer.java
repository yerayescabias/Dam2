package fifthexercise;

import java.io.*;
import java.net.*;

public class StudentServer {
    private static int idCounter = 0;
    public static final int PORT = 2626;
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port: "+ PORT);
            
            while (true) {
                try (Socket socket = serverSocket.accept();
                     ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
                    
                    Student student = (Student) in.readObject();
                    student.setId(idCounter + 1);
                    out.writeObject(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}