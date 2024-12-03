package fifthexercise;

import java.io.*;
import java.net.*;

public class StudentClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12349);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
            
            Student student = new Student("Ignacio Arrizabalaga", 19, 1.9f);
            out.writeObject(student);
            
            Student updatedStudent = (Student) in.readObject();
            System.out.println("Student: " + updatedStudent + "just arrived.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}