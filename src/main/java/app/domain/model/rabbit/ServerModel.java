package app.domain.model.rabbit;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">tianjian</a>
 * @version 1.0, 2017/10/13
 * @description
 */
public class ServerModel {
    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 业务类型
     */
    private String type;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 对应rabbitmq服务的exchange
     */
    private String exchange;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 队列的名称
     */
    private String queuename;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getQueuename() {
        return queuename;
    }

    public void setQueuename(String queuename) {
        this.queuename = queuename;
    }
}
