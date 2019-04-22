package spx.baicai.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spx.baicai.admin.service.HelloService;

@Controller
public class IndexController {
    @Autowired
    HelloService helloService;

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index() {
        log.info(helloService.sayHello("log..."));
        return "index";
    }
}
