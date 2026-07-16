package unai.mvc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import unai.mvc.models.dto.ParamDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("foo") // http://localhost:8080/api/params/foo?message=HolaMundo!!
    public ParamDto foo(
            @RequestParam(required = false, defaultValue = "Por defecto") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("bar") // http://localhost:8080/api/params/bar?text=mensaje&code=404
    public ParamDto bar(@RequestParam() String text, @RequestParam Integer code) {
        ParamDto params = new ParamDto();
        params.setMessage(text);
        params.setCode(code);

        return params;
    }

    @GetMapping("/request") // http://localhost:8080/api/params/request?text=mensaje&code=404
    public ParamDto request(HttpServletRequest request) {
        ParamDto params = new ParamDto();
        params.setCode(Integer.parseInt(request.getParameter("code")));
        params.setMessage(request.getParameter("text"));

        return params;
    }

}
