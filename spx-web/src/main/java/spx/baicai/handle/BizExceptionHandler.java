package spx.baicai.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import spx.baicai.common.ExceptionRespEntity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class BizExceptionHandler extends ResponseEntityExceptionHandler {

    protected static Logger log = LoggerFactory.getLogger(BizExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ExceptionRespEntity runtimeExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
            log.error("runtimeExceptionHandler",e);
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            RuntimeException exception = (RuntimeException) e;
            return new ExceptionRespEntity(400, exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView errorResult(Exception ex) {
        log.error("ModelAndView errorResult",ex);
        ModelAndView context=new ModelAndView("/error/5xx");
        context.addObject("errorCode","500");
        context.addObject("errorMsg", ex!=null?ex.getMessage():"异常");
        return context;
    }

    /**
     * 通用的接口映射异常处理方
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            return new ResponseEntity<>(new ExceptionRespEntity(status.value(), exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()), status);
        }
        if (ex instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
            logger.error("参数转换失败，方法：" + exception.getParameter().getMethod().getName() + "，参数：" + exception.getName()
                    + ",信息：" + exception.getLocalizedMessage());
            return new ResponseEntity<>(new ExceptionRespEntity(status.value(), "参数转换失败"), status);
        }
        log.error("handleExceptionInternal",ex);
        return new ResponseEntity<>(new ExceptionRespEntity(status.value(), "参数转换失败"), status);
    }
}
