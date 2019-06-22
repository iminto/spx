package spx.baicai.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        request.setAttribute("errorMsg",statusCode);
        if(statusCode == 404){
            return "/error/error";
        }else{
            return "/error/error";
        }

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
