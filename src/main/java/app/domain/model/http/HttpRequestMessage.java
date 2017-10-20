package app.domain.model.http;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/13
 * @description
 */
public class HttpRequestMessage {



    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 业务类型
     */
    private String type;


    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 消息内容
     */
    private Object message;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 对话安全信息(token 用户名和密码加密AES加密)
     */
    private String token;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
