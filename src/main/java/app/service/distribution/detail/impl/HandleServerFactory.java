package app.service.distribution.detail.impl;

import app.domain.model.rabbit.RabbitMessageInfo;
import app.service.distribution.detail.HandleServer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/13
 * @description 工厂类实现了服务管理
 */
@Service
public class HandleServerFactory implements HandleServer {

    Map<String,HandleServer> registerHandleServers = new HashMap<String,HandleServer>();

    @Override
    public Object handleMessage(RabbitMessageInfo message) {
        return registerHandleServers.get(message.getServerModel().getType()).handleMessage(message);
    }

    public void registerHandlerServer(String type, HandleServer handleServer) {
        registerHandleServers.put(type, handleServer);
    }
}
