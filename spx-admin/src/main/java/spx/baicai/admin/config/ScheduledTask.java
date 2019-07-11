package spx.baicai.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import spx.baicai.admin.handle.MyHandler;
import java.util.Date;

@Component
public class ScheduledTask {
    @Autowired
    MyHandler handler;

    @Scheduled(fixedRate = 30000)
    public void pushToWebSocket(){
        Date date=new Date();
        boolean send=handler.sendMessageToAllUsers(new TextMessage("我来给你们发消息了"+date));
        System.out.println("服务器端推送消息结果："+send);
    }
}
