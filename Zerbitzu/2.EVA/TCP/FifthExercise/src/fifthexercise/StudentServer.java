package fifthexercise;

import java.io.*;
import java.net.*;

public class StudentServer {
    private static int idCounter = 0;

    private static synchronized int generateUniqueId() {
        return ++idCounter;
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12349)) {
            System.out.println("Server is running on port: 12349");
            
            while (true) {
                try (Socket socket = serverSocket.accept();
                     ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
                    
                    Student student = (Student) in.readObject();
                    student.setId(generateUniqueId());
                    out.writeObject(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}