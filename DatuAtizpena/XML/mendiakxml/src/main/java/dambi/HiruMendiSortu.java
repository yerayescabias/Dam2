package dambi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class HiruMendiSortu {
    private static String csvFile="C:\\Users\\USUARIO\\Documents\\GitHub\\Dam2\\DatuAtizpena\\XML\\mendiakxml\\Mendiak.csv";
    private static String linea="";
    private static String cvsSplit=";";

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
                    mendiakxml();
                    break;
                case 2:
                    
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

    public static void mendiakxml(){
        ArrayList<String> infoPasar = new ArrayList<String>();     

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            Marshaller jMarshaller= jaxbContext.createMarshaller();
            jMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            while ((reader.readLine())!= null) {
                String[] datos = linea.split(cvsSplit);
                String mendia = datos[0];
                String altura = datos[1];
                String probintzia = datos[2];
                Mendiak mendiadatuak = new Mendiak(probintzia, mendia, altura);
                jMarshaller.marshal(mendiadatuak, new File("TUPUTAMADRE.xml"));
                jMarshaller.marshal(mendiadatuak, System.out);
                infoPasar.add(mendiadatuak.toString());
            }


        } catch (Exception e) {
            System.out.println("maircon");
        }
    }
}