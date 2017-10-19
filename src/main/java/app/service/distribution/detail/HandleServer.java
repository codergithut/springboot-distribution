package app.service.distribution.detail;

import app.domain.model.rabbit.RabbitMessageInfo;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/13
 * @description 子服务实现抽象接口
 */
public interface HandleServer {
    Object handleMessage(RabbitMessageInfo message);
}
