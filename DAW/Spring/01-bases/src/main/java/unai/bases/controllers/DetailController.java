package unai.bases.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailController {

    @GetMapping("/details")
    public String details(Model model, Map<String, Object> model2) {
        model.addAttribute("title", "Bases de Spring");
        model.addAttribute("header", "Spring con Thymeleaf");
        model.addAttribute("description", "Aprendiendo Spring Boot con la plantilla Thymeleaf");

        List<String> lists = List.of("Spring Web", "DevTools", "Thymeleaf");
        model2.put("lists", lists);

        return "details";
    }

}
