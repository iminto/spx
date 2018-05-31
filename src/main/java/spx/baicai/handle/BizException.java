package spx.baicai.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@Controller
@RequestMapping("/error")
public class BizException implements ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(BizException.class);
    private static final String PATH = "/error";
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/4xx")
    public String error404(HttpServletRequest request, HttpServletResponse resp) {
        logger.info("error404");
        request.setAttribute("error",404);
        return "error/4xx.html";

    }

    @RequestMapping("/5xx")
    public String error500(HttpServletRequest request,HttpServletResponse response) {
        logger.info("error500");
        Map<String, Object> map = new HashMap<String, Object>();
        if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
                .getHeader("X-Requested-With") != null && request.getHeader(
                "X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
            // 如果不是ajax，返回页面
            request.setAttribute("error", "系统异常！");
            return "error/5xx.html";
        }else{
            // 如果是ajax请求，JSON格式返回
            try {
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                map.put("success", false);
                // 为安全起见，只有业务异常我们对前端可见，否则统一归为系统异常
                map.put("errorMsg", "系统异常！");
                writer.write(mapper.writeValueAsString(map));
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    @RequestMapping("")
    public String error(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        return error500(request,response);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}

