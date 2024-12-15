package paagbi.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UmeaRepository {
    List<Umea> findAll();
    Umea findById(String id);
    int findOpariKopuruaUmeko(String izena);
    List<String> findOpariakUmeko(String izena);
    List<Umea> findUmeOpariAskodunak();
    Umea save(Umea person);
    long delete(String izena);
}
