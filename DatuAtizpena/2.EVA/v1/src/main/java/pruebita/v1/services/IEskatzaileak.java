package pruebita.v1.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import pruebita.v1.model.Eskatzaileak;
import pruebita.v1.model.Opariak;

@Repository
public interface IEskatzaileak {
    List<Eskatzaileak>findAll();
    Eskatzaileak create(Eskatzaileak es);
    long delete(String izena);
    List<Eskatzaileak> findMeltxor();
    
    
}   
