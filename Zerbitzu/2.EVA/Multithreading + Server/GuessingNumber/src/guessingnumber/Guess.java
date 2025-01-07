/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guessingnumber;

import java.net.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

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

    public Guess(Socket socket) {
        this.socket = socket;
        this.txandak = 6;
        bukatu = false;
        zenbakia = random.nextInt(1, 100);
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            writer.write("Ezetz igarri zenbakia txapelketa. Saiatu zenbakia asmatzen. Zorte on!!");
            writer.newLine();
            writer.flush();

            while (txandak != 0 && bukatu == false) {
                writer.write(String.valueOf(bukatu));
                writer.newLine();

                writer.write(String.valueOf(txandak));
                writer.newLine();
                writer.flush();

                aukera = Integer.valueOf(reader.readLine());

                if (aukera == zenbakia) {
                    bukatu = true;
                    writer.write(String.valueOf(bukatu));
                    writer.newLine();
                    writer.write(String.valueOf(txandak));
                    writer.newLine();
                    writer.flush();
                    break;
                } else {
                    --txandak;
                    writer.write(String.valueOf(bukatu));
                    writer.newLine();
                    writer.write(String.valueOf(txandak));
                    writer.newLine();
                    if (zenbakia > aukera) {
                        writer.write("Zenbakia " + aukera + " baino handiagoa da.");
                        writer.newLine();
                    } else if (zenbakia < aukera) {
                        writer.write("Zenbakia " + aukera + " baino txikiagoa da.");
                        writer.newLine();
                    }
                    writer.flush();
                }
            }

            if (txandak == 0) {
                writer.write("Galdu egin duzu. Zenbakia " + zenbakia + " zen.");
                writer.newLine();
                writer.flush();
            } else if (bukatu == true) {
                writer.write("Irabazi egin duzu. Txapelduna!!");
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}