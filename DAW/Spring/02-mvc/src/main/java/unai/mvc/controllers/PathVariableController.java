package unai.mvc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unai.mvc.models.User;
import unai.mvc.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    // @Value("${config.username}")
    // private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Autowired
    private Environment environment;

    @GetMapping("/baz/{message}") // http://localhost:8080/api/var/baz/mensaje%20de%20prueba
    public ParamDto baz(@PathVariable String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);

        return paramDto;
    }

    @GetMapping("/mix/{product}/{id}") // http://localhost:8080/api/var/mix/leche/4
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);

        return json;
    }

    @PostMapping("/create") // http://localhost:8080/api/var/create
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());

        return user;
    }

    @GetMapping("/values") // http://localhost:8080/api/var/values
    public Map<String, Object> getMethodName(@Value("${config.username}") String username) {

        Map<String, Object> json = new HashMap<>();
        json.put("code", code);
        json.put("username", username);
        json.put("product", product);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        json.put("listOfValues", listOfValues);
        json.put("valuesMap", valuesMap);

        return json;
    }

}
