package pruebita.v1.model;

public class Opariak {
    private String zer;
    private int lehentasuna;
    private Nori nori;

    
    public Opariak() {}

    public Opariak(String zer, int lehentasuna, Nori nori) {
        this.zer = zer;
        this.lehentasuna = lehentasuna;
        this.nori = nori;
    }

    public String getZer() {
        return zer;
    }

    public void setZer(String zer) {
        this.zer = zer;
    }

    public int getLehentasuna() {
        return lehentasuna;
    }

    public void setLehentasuna(int lehentasuna) {
        this.lehentasuna = lehentasuna;
    }

    public Nori getNori() {
        return nori;
    }

    public void setNori(Nori nori) {
        this.nori = nori;
    }
}
