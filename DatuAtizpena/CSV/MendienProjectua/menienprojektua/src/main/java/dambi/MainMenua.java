package dambi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainMenua {
    private static String csvFile = "C:\\Users\\USUARIO\\Documents\\GitHub\\Dam2\\DatuAtizpena\\MendienProjectua\\menienprojektua\\Mendiak.csv";
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENUAREN IZENBURUA");
            System.out.println("====================================");
            System.out.printf("\t1.- Mendi altuenaren informazioa Ikusi\n\t 2.- Mendiak probintziaka\n\t3.- Irten\n\nAukeratu zenbaki bat: ");
            
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    met1();
                    break;
                case 2:
                    met2();
                    break;
                case 3:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
}

public static void met1() {
    BufferedReader reader = null;
    String line = "";
    String cvsSplitBy = ";";

    String mendiAltuena = "";
    int alturamx = 0;

    try {
        reader = new BufferedReader(new FileReader(csvFile));
        
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            
            String[] datos = line.split(cvsSplitBy);

            
            int altura = Integer.parseInt(datos[1]);

            
            if (altura > alturamx) {
                alturamx = altura;
                mendiAltuena = datos[0]; 
            }
        }

        
        System.out.println("Mendi altuena: " + mendiAltuena + " da " + alturamx + " metro rekin.");

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public static void met2() {
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ";";

        Map<String, List<String>> mendiProbintziaka = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader(csvFile));
            
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                
                String[] datos = line.split(cvsSplitBy);
                String mendia = datos[0];
                String altura = datos[1];
                String probintzia = datos[2];

                
                String lineaMonte = mendia + ";" + altura + ";" + probintzia;

                
                if (!mendiProbintziaka.containsKey(probintzia)) {
                    mendiProbintziaka.put(probintzia, new ArrayList<>());
                }
                mendiProbintziaka.get(probintzia).add(lineaMonte);
            }

            
            for (String provincia : mendiProbintziaka.keySet()) {
                String fileName = provincia + ".csv";
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                
                writer.write("MENDIA;ALTUERA;PROBINTZIA\n");

                
                for (String monteData : mendiProbintziaka.get(provincia)) {
                    writer.write(monteData + "\n");
                }

                writer.close();
                System.out.println(" Fitxategia sortuta: " + fileName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}