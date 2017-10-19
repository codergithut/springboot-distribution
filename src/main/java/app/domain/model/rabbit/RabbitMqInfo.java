package app.domain.model.rabbit;

/**
 * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
 * @version 1.0, 2017/9/20
 * @description RabbitMq 对象
 */
public class RabbitMqInfo {
    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description rabbitmq host
     */
    private String host;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description rabbitmq password
     */
    private String password;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description rabbitmq username
     */
    private String username;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description rabbitmq port
     */
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
