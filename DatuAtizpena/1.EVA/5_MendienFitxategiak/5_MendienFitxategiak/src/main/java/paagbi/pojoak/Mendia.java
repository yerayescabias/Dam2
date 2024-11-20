package paagbi.pojoak;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mendia {
    private int id;
    private String mendia, probintzia;
    private int altuera;

    //#region Constructores

    public Mendia() {} // Constructor para hacer procesos con los Archivos .xml

    public Mendia(int id, String mendia, int altuera, String probintzia) {
        this.id = id;
        this.mendia = mendia;
        this.altuera = altuera;
        this.probintzia = probintzia;
    }

    //#endregion

    //#region Getters&Setters

    @XmlElement (name = "Id")
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @XmlElement (name = "Izena")
    public String getMendia() { return mendia; }

    public void setMendia(String mendia) { this.mendia = mendia; }

    @XmlElement (name = "Altuera")
    public int getAltuera() { return altuera; }

    public void setAltuera(int altuera) { this.altuera = altuera; }

    @XmlElement (name = "Probintzia")
    public String getProbintzia() { return probintzia; }

    public void setProbintzia(String probintzia) { this.probintzia = probintzia; }
    
    //#endregion

    //#region toString
    @Override
    public String toString() {
        return id+";"+mendia+";"+probintzia+";"+altuera;
    }
    //#endregion
}