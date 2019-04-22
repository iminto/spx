package spx.baicai.service.facade;
import org.apache.dubbo.config.annotation.Service;
import spx.baicai.api.Hello;

@Service(version = "1.0.0",retries = 1,timeout = 10000)
public class HelloServiceImpl implements Hello {
    @Override
    public String sayHello(String name) {
        return "hello ~(from Spring Boot with dubbo-2.7.1) "+name;
    }
}
