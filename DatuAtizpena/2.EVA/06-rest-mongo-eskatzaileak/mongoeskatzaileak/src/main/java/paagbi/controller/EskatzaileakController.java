package paagbi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import paagbi.model.Eskatzaileak;
import paagbi.repository.EskatzaileaRepository;

@RestController
@RequestMapping(path="/gabonak")
public class EskatzaileakController {
    @Autowired
    private EskatzaileaRepository eskatzaileaRepository;

    @GetMapping(path="/eskatzaileguztiak")
    public @ResponseBody Iterable<Eskatzaileak>getAllEskatzaile(){
        return eskatzaileaRepository.findAll();
    }
    // @GetMapping(path = "/oparikopurua/{}")
    // @GetMapping(path = "/opariAnitzekoUmeak")
    // @GetMapping(path="/adinaaltuena")
    // @DeleteMapping(path = "/delete/{}")
    // @DeleteMapping(path="/deletenori/{}")
    // @PutMapping(path ="/lehentasunaaldatu/{}")
    // @PutMapping(path ="/oparialdatu/{}")
    // @PutMapping(path="/norialdatu/{}")
    // @PutMapping(value = "/opariberria/{}")
    // @PostMapping(path="/eskatzaileberria")



}
