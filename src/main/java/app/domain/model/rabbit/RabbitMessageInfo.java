package app.domain.model.rabbit;

/**
 * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
 * @version 1.0, 2017/9/20
 * @description 发送消息对象
 */
public class RabbitMessageInfo {

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 发动消息的内容
     */
    private String message;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 消息业务类型
     */
    private ServerModel serverModel;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description rabbitmq 链接信息
     */
    private RabbitMqInfo rabbitMqInfo;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RabbitMqInfo getRabbitMqInfo() {
        return rabbitMqInfo;
    }

    public void setRabbitMqInfo(RabbitMqInfo rabbitMqInfo) {
        this.rabbitMqInfo = rabbitMqInfo;
    }

    public ServerModel getServerModel() {
        return serverModel;
    }

    public void setServerModel(ServerModel serverModel) {
        this.serverModel = serverModel;
    }
}
