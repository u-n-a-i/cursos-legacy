package unai.bases.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import unai.bases.models.User;

@RestController
@RequestMapping("/api") // Ruta de primer nivel
public class UserRestController {

    // @RequestMapping(path = "user", method = RequestMethod.GET) -> Otra forma, más
    // simple GetMapping
    @GetMapping("/user") // Ruta de segundo nivel
    public Map<String, Object> user(Model model) {

        // * Datos en duro
        // Map<String, Object> body = new HashMap<>();
        // body.put("title", "El nombre");
        // body.put("age", 90);
        // body.put("city", "La ciudad");

        // * Datos de una clase
        User user = new User("Nombre", "Apellido");

        Map<String, Object> body = new HashMap<>();
        // body.put("name", user.getName());
        // body.put("lastName", user.getLastName());
        body.put("user", user);

        return body; // Devuelve un JSON
    }

}
