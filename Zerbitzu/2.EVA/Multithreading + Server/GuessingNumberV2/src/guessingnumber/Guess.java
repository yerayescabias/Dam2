/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guessingnumber;

import java.net.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Guess implements Runnable {
    private Socket socket;
    private int txandak;
    private boolean bukatu;
    private int zenbakia;
    private int aukera;
    Random random = new Random();
    private Ranking ranking;

    public Guess(Socket socket, Ranking ranking) {
        this.socket = socket;
        this.txandak = 6;
        bukatu = false;
        zenbakia = random.nextInt(1, 100);
        this.ranking= ranking;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            writer.write("Ezetz igarri zenbakia txapelketa. Saiatu zenbakia asmatzen. Zorte on!!");
            writer.newLine();
            writer.flush();
            
            for(int i=0;txandak!=0&& bukatu==false;txandak--){
                
                writer.write(String.valueOf(bukatu).toLowerCase().strip());
                writer.newLine();
                writer.flush();
                aukera=Integer.parseInt(reader.readLine());
                if(aukera==zenbakia){bukatu=true;}
                else{
                    writer.write("Ez duzu asmatu berriro saiatu");
                     writer.newLine();
                     writer.flush();
                     if(aukera>zenbakia){writer.write("Zenbakia txikiagoa izango da");writer.newLine();
                     writer.flush();}
                     if(aukera<zenbakia){writer.write("Zenbakia handiago izango da");writer.newLine();
                     writer.flush();}
                }
           }
           if(bukatu){writer.write("Irabazi duzu, zenbakia "+ zenbakia+ " da");
                      writer.newLine();
                      writer.flush();}
           else{writer.write("Galdu duzu,zenbakia "+ zenbakia+ " da");
                writer.newLine();
                writer.flush();}
           ranking.ranking(true);
           writer.write(ranking.texto(txandak));
           writer.newLine();
           writer.flush();
           
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(Guess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Guess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}