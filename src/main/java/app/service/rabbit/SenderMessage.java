package app.service.rabbit;

import app.domain.model.rabbit.RabbitMqInfo;
import app.domain.model.rabbit.RabbitMessageInfo;
import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
 * @version 1.0, 2017/9/20
 * @description 发送消息服务
 */
@Service
public class SenderMessage {

    private static Connection connection = null;

    public static void sendQueueMessage(final RabbitMessageInfo messageInfo) throws IOException, TimeoutException {

        Connection connection = getConnectionInstance(messageInfo.getRabbitMqInfo());

        Channel channel = connection.createChannel();
        channel.queueDeclare(messageInfo.getServerModel().getExchange(), true, false, false, null);

        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties();
        channel.basicPublish(messageInfo.getServerModel().getExchange(), messageInfo.getServerModel().getExchange(), basicProperties, JSON.toJSONString(messageInfo).getBytes());

        connection.close();
    }

    private static Connection getConnectionInstance(RabbitMqInfo rabbitMqInfo) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitMqInfo.getHost());
        factory.setUsername(rabbitMqInfo.getUsername());
        factory.setPassword(rabbitMqInfo.getPassword());
        factory.setPort(rabbitMqInfo.getPort());
        connection = factory.newConnection();
        return connection;
    }
}