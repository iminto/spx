package spx.baicai.service.facade;
import org.apache.dubbo.config.annotation.Service;
import spx.baicai.api.Hello;

@Service
public class HelloServiceImpl implements Hello {
    @Override
    public String sayHello(String name) {
        return "hello ~(from Spring Boot with dubbo-2.7.1) "+name;
    }
}
