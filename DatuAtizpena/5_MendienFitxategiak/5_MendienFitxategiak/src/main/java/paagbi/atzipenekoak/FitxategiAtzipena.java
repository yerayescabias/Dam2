package paagbi.atzipenekoak;

import paagbi.pojoak.Mendiak;

public abstract class FitxategiAtzipena {
    protected String strFileIn;
    protected String strFileOut;
    
    public FitxategiAtzipena(String fileIn){
        this.strFileIn = fileIn;
    }

    public FitxategiAtzipena(String fileIn, String fileOut) {
        this.strFileIn = fileIn;
        this.strFileOut = fileOut;
    }

    public abstract Mendiak irakurri();
    
    public abstract void idatzi(Mendiak mendia);
}
