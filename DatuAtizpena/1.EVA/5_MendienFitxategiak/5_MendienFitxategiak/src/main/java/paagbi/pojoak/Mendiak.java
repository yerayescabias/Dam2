package paagbi.pojoak;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Mendiak")
public class Mendiak {
    private List<Mendia> mendiak;

    //#region Constructores

    public Mendiak() {} // Constructor para hacer procesos con los Archivos .xml

    public Mendiak(List<Mendia> mendiak) { // Constructor para Guardar los Datos del Objeto Mendia
        this.mendiak = mendiak;
    }

    //#endregion

    //#region Getters&Setters

    @XmlElement (name = "Mendia")
    public List<Mendia> getMendiak() { return mendiak; }

    public void setMendiZerrenda(List<Mendia> mendiak) { this.mendiak = mendiak; }

    //#endregion

    //#region toString
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Mendia museum : this.mendiak) {
            str.append(museum.toString());
        }
        return str.toString();
    }
    //#endregion
}
