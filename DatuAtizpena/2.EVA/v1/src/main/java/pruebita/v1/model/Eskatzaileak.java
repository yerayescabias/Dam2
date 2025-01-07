package pruebita.v1.model;

import java.util.List;
import org.bson.types.ObjectId;

public class Eskatzaileak {
    private ObjectId id;
    private String izena;
    private List<Opariak> opariak;

    
    @Override
    public String toString() {
        return "Eskatzaileak [id=" + id + ", izena=" + izena + ", opariak=" + opariak + "]";
    }

    public Eskatzaileak() {}

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



