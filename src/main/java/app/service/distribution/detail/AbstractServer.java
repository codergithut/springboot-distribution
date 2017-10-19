package app.service.distribution.detail;

import app.service.distribution.detail.impl.HandleServerFactory;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/13
 * @description
 */
@Service
public abstract class AbstractServer implements RegisterServer, HandleServer{

    HandleServerFactory handleServerFactory;

    public AbstractServer(String type, HandleServerFactory handleServerFactory) {
        this.handleServerFactory = handleServerFactory;
        registerHandlerServer(type, this);
    }

    @Override
    public void registerHandlerServer(String type, HandleServer handleServer) {
        handleServerFactory.registerHandlerServer(type, this);
    }

}
