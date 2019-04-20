package spx.baicai.handle;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import spx.baicai.exception.BusinessException;

@Component
public class ErrorConfigure implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage[] errorPages=new ErrorPage[4];
        errorPages[0]=new ErrorPage(HttpStatus.NOT_FOUND, "/error/4xx");
        errorPages[1]=new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error");
        errorPages[2]=new ErrorPage(BusinessException.class, "/error");
        errorPages[3]=new ErrorPage(Exception.class, "/error");
        registry.addErrorPages(errorPages);
    }
}
