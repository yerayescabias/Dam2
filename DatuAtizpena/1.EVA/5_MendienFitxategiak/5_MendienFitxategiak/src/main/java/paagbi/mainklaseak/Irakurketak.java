package paagbi.mainklaseak;

import paagbi.atzipenekoak.Csva;
import paagbi.atzipenekoak.Jsona;
import paagbi.atzipenekoak.Xmla;
import paagbi.pojoak.Mendia;
import paagbi.pojoak.Mendiak;

public class Irakurketak {
    public static void main(String[] args) {
        Mendiak mendiak = new Mendiak();

        System.out.println("\n=========MENDIEN IRAKURKETA==========\n");

        Csva csva = new Csva("src\\main\\resources\\csv\\Mendiak.csv");
        mendiak = csva.irakurri();

        Xmla xmla = new Xmla(null, "src\\main\\resources\\xml\\Mendiak.xml");
        xmla.idatzi(mendiak);

        Jsona jsona = new Jsona(null, "src\\main\\resources\\json\\Mendiak.json");
        jsona.idatzi(mendiak);

        for (Mendia mendia : mendiak.getMendiak()) {
            System.out.println(mendia.toString());
        }
    }
}
