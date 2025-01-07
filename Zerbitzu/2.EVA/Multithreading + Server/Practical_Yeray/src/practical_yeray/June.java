/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practical_yeray;


import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class June {
    public static void main(String[] args) throws UnknownHostException, IOException {
        int port = 12321;
        InetAddress ip = InetAddress.getLocalHost();
        Socket june = new Socket(ip, port);
        String line;
        Scanner sc = new Scanner(System.in);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(june.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(june.getOutputStream()));
            while((line =reader.readLine())!= null){
                System.out.println(line);
            }
            System.out.print("Reply : ");
            writer.write(sc.next());
            writer.newLine();
            writer.flush();
            System.out.println(reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            june.close();
            sc.close();
        }
        
    }
}
