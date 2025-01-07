package guessingnumber;

import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Administrador
 */
public class Client {
    

        public static void main(String[] args) throws UnknownHostException, IOException {
        int serverPort = 2626;
        InetAddress ip = InetAddress.getLocalHost();
        try (Socket client = new Socket(ip, serverPort);
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                Scanner sc = new Scanner(System.in);) {
            
            String line;
            while((line=reader.readLine())!= null){
                if(line.equals("false")){
                    System.out.print("Zure aukera: ");
                    writer.write(sc.next());
                    writer.newLine();
                    writer.flush();
                }else if(!(line.equals("false")) || !(line.equals("true")))
                {
                    System.out.println(line);
                }        
            }
            
         

        }
    
        }

}

