package exam;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
    public class Exam implements Runnable {

        private Socket client;
        public String[] preguntas;
        public String[][] respuestas;
        public String[] correctas;
        public String[] respondidas;
        public int puntuacion;
        
        public Exam(Socket client) {
            this.client = client;
            preguntas = new String[]{
                "Which of the following is a connection-oriented transport protocol? ",
                "What type of applications benefit most from the UDP protocol? ",
                "What is the function of the \"Acknowledgment\" (ACK) field in the TCP header?",
                "Which of the following is a connectionless transport protocol? ",
                "What type of service does TCP offer compared to UDP? "};
            respuestas = new String[][]{{"a) TCP", " b) UDP", "c) IP"},
            {"a) File transfer", "b) Video conferencing and voice transmission", "c) Web browsing "},
            {"a) Confirming data delivery", "b) Establishing the initial connection", " c) Managing routing"},
            {"a) TCP", " b) UDP", "c) FTP"},
            {"a) Unreliable service ", "b) Reliable and connection-oriented service", "c) Broadcast-oriented service"}};
            correctas = new String[]{"a", "b", "a", "b", "b"};
            respondidas = new String[preguntas.length];
            

        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                writer.write("Exam is going to start");
                writer.newLine();
                for (int preguntaactual = 0; preguntaactual < preguntas.length; preguntaactual++) {
                    writer.write(preguntas[preguntaactual]);
                    writer.newLine();
                    for (int respuestasactuales = 0; respuestasactuales <= 2; respuestasactuales++) {
                        writer.write(respuestas[preguntaactual][respuestasactuales]);
                        writer.newLine();
                        writer.flush();
                    }
                    writer.write("para");
                    writer.newLine();
                    writer.flush();
                    while (respondidas[preguntaactual] == null) {
                        String line = reader.readLine();
                        if (line.isBlank()) {
                            respondidas[preguntaactual] = null;
                            writer.write("para");
                            writer.newLine();
                            writer.flush();
                        } else if (preguntaactual == 5) {
                            writer.write("seco");
                            break;
                        } else {
                            respondidas[preguntaactual] = line;
                            Comparacion(line, preguntaactual);
                        }
                    }

                }

                if (puntuacion >= ((correctas.length + 1) / 2)) {
                    writer.write("Your final mark is " + puntuacion + " muy bien campeon");
                    writer.newLine();
                    writer.flush();
                } else {
                    writer.write("Your final mark is " + puntuacion + " vaya desprovecho y desecho social");
                    writer.newLine();
                    writer.flush();
                }
                
                client.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void Comparacion(String line, int npregunta) {
            if (line.equals(correctas[npregunta])) {
                puntuacion++;
            }
        }

    }
