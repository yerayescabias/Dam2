package dambi;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Mendiak")
public class MendiakWrapper {
    private List<Mendiak> mendiak;

    @XmlElement(name = "Mendia")
    public List<Mendiak> getMendiak() {
        return mendiak;
    }

    public void setMendiak(List<Mendiak> mendiak) {
        this.mendiak = mendiak;
    }


}
