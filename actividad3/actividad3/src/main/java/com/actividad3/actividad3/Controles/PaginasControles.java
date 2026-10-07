package com.actividad3.actividad3.Controles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@Controller para devolver vista/página web
public class PaginasControles {

    @GetMapping("/elegir")
    //defaultValue="english", con esto hacemos que el valor por defecto, sea la página en inglés
    //@RequestParam para recoger dato que viene de la URL
    public String paginas(@RequestParam(name="idioma", defaultValue ="english")String name){

        switch (name){
            case "spanish":
                return "redirect:/spanish.html";

            case "french":
                return "redirect:/french.html";

            case "english":
                return "redirect:/english.html";

            case "german":
                return "redirect:/german.html";

            default:
                return "redirect:/english.html";
        }
    }
}
