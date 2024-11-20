package paagbi.mainklaseak;

import paagbi.atzipenekoak.*;
import paagbi.pojoak.Mendiak;

public class CsvtikJsonera {
    public static void main(String[] args) {
        Csva csv = new Csva("src\\main\\resources\\csv\\Mendiak.csv");
        Mendiak mendia = csv.irakurri();

        Jsona json = new Jsona(null, "src\\main\\resources\\json\\csvJson.json");
        json.idatzi(mendia);
    }
}
