package dambi;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"mendia","altuera","probintzia"})
@XmlRootElement(name = "HiruMenndiSortu")
public class Mendiak {
    
    public String probintzia;
    public String mendia;
    public String altuera;

    public String getProbintzia() {
        return probintzia;
    }
    @XmlElement(name = "PROBINTZIA")
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    public String getMendia() {
        return mendia;
    }
    @XmlElement(name = "MENIDA")
    public void setMendia(String mendia) {
        this.mendia = mendia;
    }

    @Override
    public String toString() {
        return mendia +";"+altuera+";"+probintzia;
    }
    
    @XmlElement(name = "ALTUERA")
    public String getAltuera() {
        return altuera;
    }

    public void setAltuera(String altuera) {
        this.altuera = altuera;
    }

    public Mendiak(String probintzia,String mendia,String altuera){
        this.altuera=altuera;
        this.probintzia=probintzia;
        this.mendia=mendia;
    }

}
