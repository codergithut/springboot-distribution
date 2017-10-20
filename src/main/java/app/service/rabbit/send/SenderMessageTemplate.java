package app.service.rabbit.send;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/20
 * @description
 */
@Component
public class SenderMessageTemplate {

    private final AmqpAdmin amqpAdmin;
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public SenderMessageTemplate(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
    }

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @param
     * @return
     * @description 使用默认消息默认参数发送消息
     */
    public void senderMessage(String message, String routingKey, String exchange) {
        amqpTemplate.send(exchange, routingKey, new Message(message.getBytes(), new MessageProperties()) );
    }

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @param
     * @return
     * @description 指明特定参数发送消息
     */
    public void senderMessage(String message, String routingKey, String exchange, MessageProperties messageProperties) {
        amqpTemplate.send(exchange, routingKey, new Message(message.getBytes(), messageProperties));
    }

}
