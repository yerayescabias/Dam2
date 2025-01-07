package paagbi.api_eskatzaileak.metods;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import paagbi.api_eskatzaileak.model.Eskatzailea;
import paagbi.api_eskatzaileak.model.Oparia;

@Repository
public interface EskatzaileaRepository {
    public List<Eskatzailea> getAll();
    public Eskatzailea findById(String id);
    public Eskatzailea aurkituIzenarenBidez(String izena);
    public List<Oparia> erabiltzailearenOpariak(String name);
    public int opariakErabiltzaileko(String name);
    public Map<String, Integer> zenbatOpariakNori();
    public List<String> findReceiversByNori(String giverName);
    public Eskatzailea opariGehien();

    public Eskatzailea add(Eskatzailea eskatzailea);
    public long update(String id, Eskatzailea eskatzailea);
    public long delete(String name); 
}
