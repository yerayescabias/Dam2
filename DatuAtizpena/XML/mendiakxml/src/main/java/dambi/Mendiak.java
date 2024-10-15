package dambi;

public class Mendiak {
    
    public String probintzia;
    public String mendia;
    public String altuera;

    public String getProbintzia() {
        return probintzia;
    }

    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    public String getMendia() {
        return mendia;
    }

    public void setMendia(String mendia) {
        this.mendia = mendia;
    }

    @Override
    public String toString() {
        return mendia +";"+altuera+";"+probintzia;
    }

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
