/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pitagoras2;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Pitagoras implements Runnable {
    DatagramPacket general;
    int num1;
    int num2;
     DatagramSocket server;

    public Pitagoras(DatagramPacket num1, DatagramPacket num2,DatagramSocket server) {
        this.num1 = Integer.parseInt(new String(num1.getData(), 0, num1.getLength()));
        this.num2 = Integer.parseInt(new String(num2.getData(), 0, num2.getLength()));
        general = num1;
        this.server = server;
        
    }

    @Override
    public void run() {

        try {
            double hipotesuna = num1 * num1 + num2 * num2;
            double resultado = Math.sqrt(hipotesuna);
            
            DatagramPacket enviar = new DatagramPacket(new String(String.valueOf(resultado)).getBytes(), new String(String.valueOf(resultado)).getBytes().length,general.getAddress(), general.getPort());
            server.send(enviar);
            
        } catch (Exception ex) {
            Logger.getLogger(Pitagoras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
