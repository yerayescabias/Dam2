package paagbi.atzipenekoak;

import paagbi.pojoak.Mendia;
import paagbi.pojoak.Mendiak;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

public class Jsona extends FitxategiAtzipena{

    public Jsona(String fileIn) {
        super(fileIn);
    }

    public Jsona(String fileIn, String fileOut) {
        super(fileIn, fileOut);
    }

    @Override
    public Mendiak irakurri() {
        List<Mendia> mendiakList = new ArrayList<>();

        try (InputStream inputS = new FileInputStream(new File(strFileIn))) {
            JsonReader reader = Json.createReader(inputS);
            JsonObject jsonObj = reader.readObject();
            
            jsonObj.getJsonArray("mendiak").forEach(jsonValue -> {
                Mendia mendia = new Mendia(
                    jsonObj.getInt("Id"),
                    jsonObj.getString("Izena"),
                    jsonObj.getInt("Altuera"),
                    jsonObj.getString("Probintzia")
                );
                mendiakList.add(mendia);
            });
            return new Mendiak(mendiakList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void idatzi(Mendiak mendiak) {
        try (OutputStream fos = new FileOutputStream(strFileOut);
            JsonWriter writer = Json.createWriter(fos)) {

            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            for (Mendia mendia : mendiak.getMendiak()) {
                JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
                    .add("Id", mendia.getId())
                    .add("Izena", mendia.getMendia())
                    .add("Altuera", mendia.getAltuera())
                    .add("Probintzia", mendia.getProbintzia());
                arrayBuilder.add(objectBuilder.build());
            }
            JsonObject jsonObject = Json.createObjectBuilder()
                .add("mendiak", arrayBuilder.build())
                .build();

            writer.writeObject(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
