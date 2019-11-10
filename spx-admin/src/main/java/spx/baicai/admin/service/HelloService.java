package spx.baicai.admin.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import spx.baicai.api.Hello;

@Service
public class HelloService {
    @Reference(retries = 2,check = false)
    private Hello hello;

    public String sayHello(String name) {
        return hello.sayHello(name);
    }


}
