package pruebita.v1.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import pruebita.v1.model.Eskatzaileak;

@Repository
public interface IEskatzaileak {
    List<Eskatzaileak>findAll();
    Eskatzaileak create(Eskatzaileak es);
    long delete(String izena);
    
}   
