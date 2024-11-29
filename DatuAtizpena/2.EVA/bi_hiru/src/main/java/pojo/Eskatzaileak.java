package pojo;

import java.util.List;

import org.bson.types.ObjectId;

public class Eskatzaileak {
    private ObjectId id;
    private String izena;
    private List<Opariak> opariak;

    public Eskatzaileak() {
    }

    public Eskatzaileak(ObjectId id, String izena, List<Opariak> opariak) {
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

    public List<Opariak> getOpariak() {
        return opariak;
    }

    public void setOpariak(List<Opariak> opariak) {
        this.opariak = opariak;
    }

}
