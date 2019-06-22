package spx.baicai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring boot 入口类
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    String home() {
        return "Greetings from Spring Boot!";
    }

}

