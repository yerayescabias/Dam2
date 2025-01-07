package paagbi.api_eskatzaileak.controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import paagbi.api_eskatzaileak.metods.EskatzaileaRepository;
import paagbi.api_eskatzaileak.model.Eskatzailea;
import paagbi.api_eskatzaileak.model.Oparia;

@RestController
@RequestMapping(path = "/gabonak")
public class EskatzaileaController {
    @Autowired
    private EskatzaileaRepository eskatzaileaRepository;

    @GetMapping(path = "/getAll")
    public @ResponseBody Iterable<Eskatzailea> getAll() {
        try {
            return eskatzaileaRepository.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping(path = "/findById/{id}")
    public @ResponseBody Eskatzailea findById(@PathVariable String id) {
        try {
            return eskatzaileaRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping(path = "/aurkituIzenarenBidez/{izena}")
    public @ResponseBody Eskatzailea aurkituIzenarenBidez(@PathVariable String izena) {
        try {
            return eskatzaileaRepository.aurkituIzenarenBidez(izena);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping(path = "/erabiltzailearenOpariak/{izena}")
    public @ResponseBody Iterable<Oparia> erabiltzailearenOpariak(@PathVariable String izena) {
        try {
            return eskatzaileaRepository.erabiltzailearenOpariak(izena);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping(path = "/opariakErabiltzaileko/{izena}")
    public @ResponseBody int opariakErabiltzaileko(@PathVariable String izena) {
        try {
            return eskatzaileaRepository.opariakErabiltzaileko(izena);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @GetMapping(path = "/zenbatOpariakNori")
    public @ResponseBody Map<String, Integer> zenbatOpariakNori() {
        try {
            return eskatzaileaRepository.zenbatOpariakNori();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping(path = "/receiversByNori/{giverName}")
    public @ResponseBody List<String> findReceiversByNori(@PathVariable String giverName) {
        try {
            return eskatzaileaRepository.findReceiversByNori(giverName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping(path = "/opariGehien")
    public @ResponseBody Eskatzailea opariGehien() {
        try {
            return eskatzaileaRepository.opariGehien(); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @PostMapping(path = "/add")
    public @ResponseBody Eskatzailea add(@RequestBody Eskatzailea eskatzailea) {
        try {
            return eskatzaileaRepository.add(eskatzailea);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody long update(@PathVariable String id, @RequestBody Eskatzailea eskatzailea) {
        try {
            return eskatzaileaRepository.update(id, eskatzailea);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody long delete(@PathVariable String id) {
        try {
            return eskatzaileaRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
