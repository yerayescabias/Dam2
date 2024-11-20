package paagbi.mainklaseak;
import paagbi.atzipenekoak.*;
import paagbi.pojoak.Mendiak;

public class CsvtikXmlra {
    public static void main(String[] args) {
        Csva csv = new Csva("src\\main\\resources\\csv\\Mendiak.csv");
        Mendiak mendia = csv.irakurri();

        Xmla xml = new Xmla(null, "src\\main\\resources\\xml\\csvXml.xml");
        xml.idatzi(mendia);
    }
}
