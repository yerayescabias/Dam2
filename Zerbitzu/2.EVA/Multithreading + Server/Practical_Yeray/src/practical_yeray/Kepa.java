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
public class Kepa {
    public static void main(String[] args) throws UnknownHostException {
        int port = 2626;
        InetAddress ip = InetAddress.getLocalHost();
        Scanner sc = new Scanner(System.in);
        
        try(Socket kepa = new Socket(ip, port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(kepa.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(kepa.getOutputStream()));){
            System.out.println("Which amount of money do you want to send");
            int money = sc.nextInt();
            String line;
            while(money!=0 && money>250){
                money = sc.nextInt();
            }
            // June enviar 
            writer.write(String.valueOf(money));
            writer.newLine();
            writer.flush();
            writer.write("I'm sending "+String.valueOf(money)+"€");
            writer.newLine();
            writer.flush(); 
            while((line=reader.readLine())!= null){
                System.out.println(line);
            }
            while(reader.readLine()==null){
                
            }
            System.out.println(reader.readLine());
            System.out.print("Reply:");
            writer.write(sc.next());
            writer.newLine();
            writer.flush();
            
        } catch (Exception e) {
        }
    }
}
