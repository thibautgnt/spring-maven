package fr.efrei.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Thibaut Genet");
        model.addAttribute("course", "DevSecOps");
        return "index";
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Bonjour, monde !";
    }
}
