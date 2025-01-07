/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practical_yeray;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Calculation implements Runnable {

    private final Socket june;
    private final Socket kepa;
    private int money;
    private String line;

    public Calculation(Socket kepa, Socket june) {
        this.kepa = kepa;
        this.june = june;

    }

    @Override
    public void run() {
        try {
            BufferedReader kepareader = new BufferedReader(new InputStreamReader(kepa.getInputStream()));
            BufferedWriter kepawriter = new BufferedWriter(new OutputStreamWriter(kepa.getOutputStream()));
            BufferedWriter junewriter = new BufferedWriter(new OutputStreamWriter(june.getOutputStream()));
            BufferedReader junereader = new BufferedReader(new InputStreamReader(june.getInputStream()));
            
            int money = Integer.parseInt(kepareader.readLine());
            junewriter.write(kepareader.readLine());
            double months = money / 80;
            double moneytotal = months * 80;
            double left = Math.abs(months - money);
            try {
                kepawriter.write("I can pay for " + months + "(" + months + "*" + "80 = " + moneytotal);
                kepawriter.newLine();
                kepawriter.flush();
                kepawriter.write("There is " + left + " left");
                kepawriter.newLine();
                kepawriter.flush();
                junewriter.write("All calculations made");
                kepawriter.newLine();
                kepawriter.flush();
            } catch (IOException ex) {
                Logger.getLogger(Calculation.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                june.close();
                kepa.close();
            } catch (Exception e) {
            }

        }

    }

}
