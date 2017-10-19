package app.service.distribution.sys.impl;

import app.config.Constant;
import app.domain.model.http.HttpRequestMessage;
import app.domain.model.http.HttpResponseMessage;
import app.domain.model.rabbit.RabbitMessageInfo;
import app.domain.model.rabbit.RabbitMqInfo;
import app.domain.model.rabbit.ServerModel;
import app.service.distribution.sys.SystemServer;
import app.service.rabbit.ReceivedMessage;
import app.service.rabbit.SenderMessage;
import app.util.SymmetricEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/13
 * @description
 */
@Service
public class SystemServerImpl implements SystemServer {

    @Autowired
    ReceivedMessage receivedMessage;


    @Override
    public HttpResponseMessage distributionServer(HttpRequestMessage httpRequestMessage) {

        String encode = SymmetricEncoder.AESEncode(Constant.AES_KEY, httpRequestMessage.getMessage());

        RabbitMqInfo rabbitMqInfo = new RabbitMqInfo();
        rabbitMqInfo.setHost("127.0.0.1");
        rabbitMqInfo.setPassword("guest");
        rabbitMqInfo.setUsername("guest");
        rabbitMqInfo.setPort(5672);

        ServerModel serverModel = new ServerModel();
        serverModel.setExchange("test");
        serverModel.setQueuename("test");
        serverModel.setType("distributionServer");

        RabbitMessageInfo messageInfo = new RabbitMessageInfo();
        messageInfo.setMessage(encode);
        messageInfo.setRabbitMqInfo(rabbitMqInfo);
        messageInfo.setServerModel(serverModel);

        HttpResponseMessage httpResponseMessage = new HttpResponseMessage();
        httpResponseMessage.setCode("dafeng");
        httpResponseMessage.setErrorinfo(null);
        httpResponseMessage.setResponsecode("0000");
        httpResponseMessage.setResultinfo(encode);

        try {
            SenderMessage.sendQueueMessage(messageInfo);
            if(!ReceivedMessage.isFlag()) {
                receivedMessage.customerMessage(rabbitMqInfo, serverModel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return httpResponseMessage;
    }
}
