package app.domain.model.http;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/13
 * @description
 */
public class HttpRequestMessage {

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 地区编号
     */
    private String code;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 业务类型
     */
    private String type;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 机构名称
     */
    private String name;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 消息名称
     */
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
