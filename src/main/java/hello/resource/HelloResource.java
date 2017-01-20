package hello.resource;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloResource {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot - Anitha From Eclipse!";
    }

}
