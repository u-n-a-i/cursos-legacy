package unai.excepciones.controllers;

// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
// @RequestMapping("/")
public class AppController {

    @GetMapping("/app")
    public String index() {
        // int value = 100 / 0;
        int value = Integer.parseInt("Hola");
        System.out.println(value);
        return "ok 200";
    }

}
