package paagbi.atzipenekoak;

import paagbi.pojoak.Mendiak;
import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Xmla extends FitxategiAtzipena {

    public Xmla(String fileIn) {
        super(fileIn);
    }

    public Xmla(String fileIn, String fileOut) {
        super(fileIn, fileOut);
    }

    @Override
    public Mendiak irakurri() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Mendiak) unmarshaller.unmarshal(new File(strFileIn));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void idatzi(Mendiak mendiak) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(mendiak, new File(strFileOut));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
