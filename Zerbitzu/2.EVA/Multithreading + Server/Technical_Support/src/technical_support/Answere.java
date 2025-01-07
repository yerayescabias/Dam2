/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package technical_support;
import java.io.*;
import java.net.*;
/**
 *
 * @author Administrador
 */
public class Answere implements Runnable {
    private Socket clientSocket;

    public Answere(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            // Envía las preguntas al cliente
            writer.write(
                            "(1) Nola berrezarri nire kontu-pasahitza?\n" +
                            "(2) Nola konektatu nire gailua Wi-Fi sare batera?\n" +
                            "(3) Nola konpondu nire inprimagailuko inprimatze-arazoak?\n" +
                            "(4) Zein urrats eman behar ditut nire sistema eragilearen softwarea eguneratzeko?\n" +
                            "(5) Nola kopia ditzaket nire fitxategi garrantzitsuak?\n" +
                            "(6) Irten");
            writer.newLine();
            writer.write("EOF");
            writer.newLine();
            writer.flush();

            String userInput;
            do {
                // Lee la solicitud del cliente
                userInput = reader.readLine();
                if (userInput == null) {
                    break;
                }

                int aukera;
                try {
                    aukera = Integer.parseInt(userInput);
                } catch (NumberFormatException e) {
                    writer.write("Aukera baliogabea. Saiatu berriro.");
                    writer.newLine();
                    writer.flush();
                    continue;
                }

                // Envía la respuesta correspondiente
                String respuesta = switch (aukera) {
                    case 1 -> "Pasahitza berrezar dezakezu, saioa hasteko orrian berreskuratzeko pausoak jarraituz.";
                    case 2 ->
                        "Joan zure gailuko WiFi-aren konfiguraziora, hautatu sare erabilgarria eta sartu pasahitza, behar izanez gero.";
                    case 3 ->
                        "Egiaztatu inprimagailuaren konexioa, tinta-/paper-mailak, eta berrabiarazi inprimagailua eta ordenagailua, behar izanez gero.";
                    case 4 ->
                        "Bisitatu sistema eragilearen konfigurazioa, bilatu \"Eguneratzeak\" eta jarraitu argibideak eskuragarri dauden eguneratzeak egiaztatzeko eta aplikatzeko.";
                    case 5 ->
                        "Zure fitxategi garrantzitsuak kopia ditzakezu hodeiko biltegiratze-zerbitzuak edo kanpoko biltegiratze-gailuak (adibidez, USB) erabiliz.";
                    case 6 -> "Agur! Bezeroa deskonektatzen...";
                    default -> "Aukera baliogabea. Saiatu berriro.";
                };

                writer.write(respuesta);
                writer.newLine();
                writer.flush();

                if (aukera == 6) {
                    System.out.println("Bezeroa deskonektatu da.");
                    break;
                }

            } while (true);
        } catch (IOException e) {
            System.out.println("Errorea bezeroarekin: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

