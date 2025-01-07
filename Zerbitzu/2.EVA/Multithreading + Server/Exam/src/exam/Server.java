package exam;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Server {

    /*
        Contexto de la ariketa
        1. Las preguntas solo se enviaran si la anterior esta respondida 
            - Array de [boolean] para ver si las pregunta anterior esta respondida
            - Array con las preguntas // array con las respuestas
        2. Cuando finalice se calculara el total de acertada( pass // no pass)
        3. Hay que poner un limite de estudiantes
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        final int port = 2626;
        InetAddress ip = InetAddress.getLocalHost();
        ServerSocket server = new ServerSocket(port);

        try {
             
            Scanner sc = new Scanner(System.in);
            System.out.print("How many student are gonna take the exam ? ");
            int examAttenders = sc.nextInt();
            for (int acces = 0; acces < examAttenders; acces++) {
                 Socket client= server.accept();
                 Exam exam = new Exam(client);
                Thread t = new Thread(exam);
                t.start();
            }
           
                
            
            

        } catch (Exception e) {
        }

    }
}
