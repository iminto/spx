package spx.baicai.handle;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorConfigure implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage[] errorPages=new ErrorPage[2];
        errorPages[0]=new ErrorPage(HttpStatus.NOT_FOUND,"/error/4xx");
        errorPages[1]=new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/5xx");
        registry.addErrorPages(errorPages);
    }
}
