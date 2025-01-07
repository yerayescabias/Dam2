package paagbi.api_eskatzaileak.model;

import java.util.List;

import org.bson.types.ObjectId;

public class Eskatzailea {
    private ObjectId id;
    private String izena;
    private List<Oparia> opariak;

    public Eskatzailea() {
    }

    public Eskatzailea(ObjectId id, String izena, List<Oparia> opariak) {
        this.id = id;
        this.izena = izena;
        this.opariak = opariak;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public List<Oparia> getOpariak() {
        return opariak;
    }

    public void setOpariak(List<Oparia> opariak) {
        this.opariak = opariak;
    }

    @Override
    public String toString() {
        return "Eskatzailea [id=" + id + ", izena=" + izena + ", opariak=" + opariak + "]";
    }

       
}
