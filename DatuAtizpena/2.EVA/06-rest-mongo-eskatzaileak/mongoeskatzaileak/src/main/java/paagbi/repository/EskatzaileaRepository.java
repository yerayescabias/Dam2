package paagbi.repository;
import java.util.List;

import org.springframework.stereotype.Repository;

import paagbi.model.Eskatzaileak;

@Repository
public interface EskatzaileaRepository {
    List<Eskatzaileak> findAll();
    /* Eskatzaileak findById(String id);
    int findOpariKopuruaEskatzaileko(String izena);
    List<String> findOpariakEskatzaileko(String izena);
    List<Eskatzaileak> findEskatzailekoOpariAskodunak();
    Eskatzaileak save(Eskatzaileak person);
    long delete(String izena); */
}