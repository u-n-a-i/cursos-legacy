package unai.mvc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unai.mvc.models.User;
import unai.mvc.models.dto.UserDto;

import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/user")
    public UserDto user(Model model) {
        UserDto userDto = new UserDto();
        User user = new User("John", "Doh");
        userDto.setUser(user);
        userDto.setTitle("Titulo del Usuario");

        return userDto; // Devuelve un JSON
    }

    @GetMapping("/players")
    public List<User> list() {
        User user = new User("Lionel", "Messi");
        User user2 = new User("Neymar", "JR");
        User user3 = new User("Ronaldinho", "Gaucho");

        List<User> users = Arrays.asList(user, user2, user3);
        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        return users;
    }

    // @GetMapping("/user")
    // public Map<String, Object> user(Model model) {

    // // * Datos en duro
    // // Map<String, Object> body = new HashMap<>();
    // // body.put("title", "El nombre");
    // // body.put("age", 90);
    // // body.put("city", "La ciudad");

    // // * Datos de una clase
    // User user = new User("Nombre", "Apellido");

    // Map<String, Object> body = new HashMap<>();
    // // body.put("name", user.getName());
    // // body.put("lastName", user.getLastName());
    // body.put("user", user);

    // return body; // Devuelve un JSON
    // }

}
