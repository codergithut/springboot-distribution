package app.service.rabbit;

import app.domain.model.rabbit.RabbitMessageInfo;
import app.domain.model.rabbit.RabbitMqInfo;
import app.domain.model.rabbit.ServerModel;
import app.service.distribution.detail.impl.HandleServerFactory;
import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
 * @version 1.0, 2017/9/20
 * @description 接受消息并转换
 */
@Service
public class ReceivedMessage {

    @Autowired
    HandleServerFactory handleServerFactory;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 记录监听程序是否启动
     */
    private static boolean flag = false;

    private static Connection connection;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @param rabbitMqInfo 接受消息的实例对象
     * @return void
     * @description 接受消息并将消息进行转换并将消息发送到rabbitmq给logstash插件入ElasticSearch库
     */
    public void customerMessage(RabbitMqInfo rabbitMqInfo, ServerModel serverModel) throws IOException, TimeoutException {

        Connection connection = getConnection(rabbitMqInfo);

        flag = true;

        Channel channel = connection.createChannel();
        channel.queueDeclare(serverModel.getExchange(), true, false, false, null);

        Consumer consumer = new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {

                RabbitMessageInfo message = JSON.parseObject(new String(body, "UTF-8"), RabbitMessageInfo.class);
                String messageContent = message.getMessage();

                handleServerFactory.handleMessage(message);
                System.out.println(message.getMessage() + "======================");
            }
        };
        channel.basicConsume(serverModel.getQueuename(), true, consumer);
    }

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @param rabbitMqInfo rabbitmq 链接消息
     * @return rabbitmq链接实例
     * @description 根据rabbitMqInfo对象获得链接实例
     */
    private static Connection getConnection(RabbitMqInfo rabbitMqInfo) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost(rabbitMqInfo.getHost());
        factory.setUsername(rabbitMqInfo.getUsername());
        factory.setPassword(rabbitMqInfo.getPassword());
        factory.setPort(rabbitMqInfo.getPort());
        connection = factory.newConnection();
        return connection;
    }

    public static boolean isFlag() {
        return flag;
    }
}
