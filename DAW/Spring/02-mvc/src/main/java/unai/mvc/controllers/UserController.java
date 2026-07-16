package unai.mvc.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import unai.mvc.models.User;

@Controller
public class UserController {

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("title", "Usuario");
        model.addAttribute("header", "El usuario");
        model.addAttribute("description", "Usuario de la aplicación...");

        User user = new User("John", "Doh");
        // model.addAttribute("name", user.getName());
        // model.addAttribute("lastName", user.getLastName());
        // model.addAttribute("email", user.getEmail());
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/users")
    public String users(ModelMap modelMap) {
        // modelMap.addAttribute("users", users);
        modelMap.addAttribute("title", "Usuarios");
        return "users";
    }

    @ModelAttribute("users")
    public List<User> userModel() {
        List<User> users = Arrays.asList(
                new User("Maria", "Guzman", "mariaguzman@email.com"),
                new User("Juan", "Perez"),
                new User("Antonio", "Roe", "a_roe@email.com"));

        return users;
    }

}
