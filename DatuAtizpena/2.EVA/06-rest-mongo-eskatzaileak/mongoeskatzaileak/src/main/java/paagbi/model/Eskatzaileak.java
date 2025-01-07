package paagbi.model;

import java.util.List;



public class Eskatzaileak {
    
    String izena;
    List<String>opariak;
    
    
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public List<String> getOpariak() {  
        return opariak;
    }
    public void setOpariak(List<String> opariak) {
        this.opariak = opariak;
    }
    @Override
    public String toString() {
        return "Eskatzaileak [ izena=" + izena + ", opariak=" + opariak + "]";
    }
}
