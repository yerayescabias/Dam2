package dambi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/gabonak")
public class Main {

    @GetMapping ("/hola")
    public String saludo(){
        return "Hola mundo";
    }


    
    
}
