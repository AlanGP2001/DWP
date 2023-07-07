package mx.edu.uteq.idgs06.idgs06_02.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ControladorInicio {


    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("module", "inicio");
//        model.addAttribute("texto", "Este es un ejemplo en thymeleaf");
        return "index";
    }


}
