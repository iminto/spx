package spx.baicai.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BizExceptionController {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> exceptionHandler(Exception ex){
        Map<String,Object> map  = new HashMap<String,Object>();
        map.put("code",1001);
        map.put("errorMsg",ex.getMessage());
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView errorResult(Exception ex) {
        ModelAndView context=new ModelAndView("/error/5xx");
        context.addObject("errorCode","500");
        context.addObject("errorMsg", ex!=null?ex.getMessage():"异常");
        return context;
    }
}
