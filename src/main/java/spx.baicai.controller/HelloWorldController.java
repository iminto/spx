package spx.baicai.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring boot 入口类
 */
@RestController
public class HelloWorldController {
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    String home() {
        log.info("index...");
        return "Greetings from Spring Boot!";
    }

}

