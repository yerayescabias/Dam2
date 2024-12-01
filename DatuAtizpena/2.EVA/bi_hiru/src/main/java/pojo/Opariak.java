package pojo;

public class Opariak {
    private String oparia;
    private String nori;
    private int adina;
    private String lehentasuna;
    
    
    public Opariak() {
    }
    
    public Opariak(String oparia, String nori, int adina, String lehentasuna) {
        this.oparia = oparia;
        this.nori = nori;
        this.adina = adina;
        this.lehentasuna = lehentasuna;
    }
    public String getOparia() {
        return oparia;
    }
    public void setOparia(String oparia) {
        this.oparia = oparia;
    }
    public String getNori() {
        return nori;
    }
    public void setNori(String nori) {
        this.nori = nori;
    }
    public int getAdina() {
        return adina;
    }
    public void setAdina(int adina) {
        this.adina = adina;
    }
    public String getLehentasuna() {
        return lehentasuna;
    }
    public void setLehentasuna(String lehentasuna) {
        this.lehentasuna = lehentasuna;
    }
}
