package spx.baicai.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import spx.baicai.common.JsonUtils;

@Component
public class KafkaSender<T> {
    private Logger logger = LoggerFactory.getLogger(KafkaSender.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * kafka 发送消息
     *
     * @param obj 消息对象
     */
    public void send(String topic, T obj) {
        String jsonObj = JsonUtils.encode(obj);
        //发送消息
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, jsonObj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info("Produce: The message failed to be sent:" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                logger.info("Produce: The message was sent successfully:");
            }
        });
    }

    public void send(String topic, T obj, ListenableFutureCallback<SendResult<String, Object>> callback) {
        String jsonObj = JsonUtils.encode(obj);
        //发送消息
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, jsonObj);
        if (callback != null)
            future.addCallback(callback);
    }

    public void sendByKey(String topic, String key, T obj, ListenableFutureCallback<SendResult<String, Object>> callback) {
        String jsonObj = JsonUtils.encode(obj);
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, key, jsonObj);
        if (callback != null)
            future.addCallback(callback);
    }
}
