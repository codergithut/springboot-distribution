package app.service.distribution.detail.impl;

import app.domain.model.rabbit.RabbitMessageInfo;
import app.service.distribution.detail.AbstractServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/13
 * @description
 */
@Service
public class DistributionServerImpl extends AbstractServer {

    @Autowired
    public DistributionServerImpl(HandleServerFactory handleServerFactory) {
        super("distributionServer", handleServerFactory);
    }

    @Override
    public Object handleMessage(RabbitMessageInfo message) {
        System.out.println("xx");
        return null;
    }


}
