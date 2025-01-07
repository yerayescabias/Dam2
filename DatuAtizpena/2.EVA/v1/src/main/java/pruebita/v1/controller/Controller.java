package pruebita.v1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pruebita.v1.model.Eskatzaileak;
import pruebita.v1.model.Nori;
import pruebita.v1.model.Opariak;
import pruebita.v1.services.IEskatzaileak;

@RestController
@RequestMapping("/api")
public class Controller {
    List<Opariak> opariak;
    @Autowired
    private IEskatzaileak eskatzaileak;

    @GetMapping("/hola")
    public String saludo() {
        return "Hola mundo";
    }

    @GetMapping("/eskatzaileak")
    public @ResponseBody List<Eskatzaileak> getAllEskatzaileak() {
        return eskatzaileak.findAll();
    }

    @PostMapping("/eskatzaileberria")
    public @ResponseBody Eskatzaileak eskatzaileberria(@RequestParam String izena, @RequestParam String zer,
        @RequestParam int lehentasuna, @RequestParam String noriIzena, @RequestParam int adina) {
        opariak = new ArrayList<>();
        Eskatzaileak eskatzailea = new Eskatzaileak();
        eskatzailea.setIzena(izena);
        opariak.add(new Opariak(zer, lehentasuna, new Nori(noriIzena, adina)));
        eskatzailea.setOpariak(opariak);
        eskatzaileak.create(eskatzailea);
        return eskatzailea;

    }
    @DeleteMapping("/delete/{izena}")
    public @ResponseBody long 
}
