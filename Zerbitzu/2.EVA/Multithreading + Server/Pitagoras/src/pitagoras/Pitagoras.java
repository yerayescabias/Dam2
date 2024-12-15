/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pitagoras;

import java.io.*;
import java.net.*;

/**
 *
 * @author Administrador
 */
class Pitagoras implements Runnable {

    private final DatagramPacket first;
    private final DatagramPacket second;
    DatagramSocket socket = null;
    private float firstnumber;
    private float secondnumber;
    
    Pitagoras(DatagramPacket first,DatagramPacket second,DatagramSocket s){
       this.first = first;
       this.second = second;
       socket = s;
    }
    public void converter(){
        firstnumber= Float.parseFloat(new String(first.getData(),0,first.getLength()));
        secondnumber =Float.parseFloat( new String(second.getData(),0,second.getLength()));
    }
    @Override
    public void run(){
        try {
            converter();
            float hipotenusa =(firstnumber* firstnumber)+(secondnumber*secondnumber);
            hipotenusa = Float.parseFloat(String.valueOf(Math.sqrt(Double.parseDouble(String.valueOf(hipotenusa)))));
            String equals = String.valueOf(hipotenusa);
            DatagramPacket solution = new DatagramPacket(equals.getBytes(), equals.length(),first.getAddress(),first.getPort());
            System.out.println(firstnumber+"^2 + "+ secondnumber +"^2 = 2^ "+hipotenusa);
            socket.send(solution);
            socket.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
