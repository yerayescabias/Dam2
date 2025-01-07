package pruebita.v1.model;

public class Nori {
    private String izena;
    private int adina;

   
    public Nori() {}

    public Nori(String izena, int adina) {
        this.izena = izena;
        this.adina = adina;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public int getAdina() {
        return adina;
    }

    public void setAdina(int adina) {
        this.adina = adina;
    }
}
