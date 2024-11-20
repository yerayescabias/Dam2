package dambi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class DirektorioAnimaliak {
    
    public static void main(String[] args) throws IOException {
        
        String karpetaIzena, fitxategiIzena, edukia;

        
        try {
            Files.createDirectories(Path.of("karpeta_berriak"));

            Files.createDirectories(Path.of("karpeta_berriak/animaliak"));
            Files.createDirectories(Path.of("karpeta_berriak/animaliak/arrainak"));
            Files.createDirectories(Path.of("karpeta_berriak/animaliak/ugaztunak"));

            Files.createDirectories(Path.of("karpeta_berriak/elikagaiak"));
            Files.createDirectories(Path.of("karpeta_berriak/elikagaiak/barazkiak"));
            Files.createDirectories(Path.of("karpeta_berriak/elikagaiak/esnekiak"));
        } catch (Exception e) {
            System.out.println("Direktorioak sortuta daude jada.");
        }

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Zer zoaz deskribatzera? ");
        karpetaIzena = sc.nextLine();


        System.out.print("Zein? ");
        fitxategiIzena = sc.nextLine();

        System.out.print("Nolakoa da? ");
        edukia = sc.nextLine();

        Path fitxategia = Path.of("karpeta_berriak");

        
        if (karpetaIzena.equals("ugaztunak") || karpetaIzena.equals("arrainak")) 
        {
            if (karpetaIzena.equals("ugaztunak")) 
            {
                fitxategia = Path.of("karpeta_berriak/animaliak/ugaztunak/" + fitxategiIzena + ".txt");
            } 
            else if (karpetaIzena.equals("arrainak")) 
            {
                fitxategia = Path.of("karpeta_berriak/animaliak/arrainak/" + fitxategiIzena + ".txt");
            }
        } 
        else if (karpetaIzena.equals("barazkiak") || karpetaIzena.equals("esnekiak")) 
        {
            if (karpetaIzena.equals("barazkiak")) 
            {
                fitxategia = Path.of("karpeta_berriak/elikagaiak/barazkiak/" + fitxategiIzena + ".txt");
            } 
            else if (karpetaIzena.equals("esnekiak")) 
            {
                fitxategia = Path.of("karpeta_berriak/elikagaiak/esnekiak/" + fitxategiIzena + ".txt");
            }
        } 
        else 
        {
            System.out.println("Ez da " + karpetaIzena + "sortu edo aurkitu.");
            sc.close();
            
        }
        sc.close();


        Files.writeString(fitxategia, edukia, StandardCharsets.UTF_8);
    }
}
