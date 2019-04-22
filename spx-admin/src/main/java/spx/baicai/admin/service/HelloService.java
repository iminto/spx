package spx.baicai.admin.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import spx.baicai.api.Hello;

@Service
public class HelloService {
    @Reference
    private Hello hello;

    public String sayHello(String name) {
        return hello.sayHello(name);
    }


}
