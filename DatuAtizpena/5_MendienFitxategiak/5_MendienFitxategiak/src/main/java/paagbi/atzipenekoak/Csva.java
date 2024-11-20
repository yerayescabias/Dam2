package paagbi.atzipenekoak;

import paagbi.pojoak.Mendia;
import paagbi.pojoak.Mendiak;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Csva extends FitxategiAtzipena {

    public Csva(String fileIn) {
        super(fileIn);
    }

    public Csva(String fileIn, String fileOut) {
        super(fileIn, fileOut);
    }

    @Override
    public Mendiak irakurri() {
        List<Mendia> mendiakList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(strFileIn))) {
            String lerroa;
            reader.readLine();
            lerroa = reader.readLine();

            while ((lerroa = reader.readLine()) != null) {
                Mendia mendia = new Mendia();
                String data[] = lerroa.split(";");
                mendia.setId(Integer.parseInt(data[0]));
                mendia.setMendia(data[1]);
                mendia.setAltuera(Integer.parseInt(data[2]));
                mendia.setProbintzia(data[3]);
                mendiakList.add(mendia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Mendiak mendiak = new Mendiak(mendiakList);
        return mendiak;
    }

    @Override
    public void idatzi(Mendiak mendia) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(strFileOut))) {
            writer.write(mendia.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
