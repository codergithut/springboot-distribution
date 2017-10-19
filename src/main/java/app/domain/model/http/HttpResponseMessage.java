package app.domain.model.http;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/13
 * @description
 */
public class HttpResponseMessage {

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 请求返回编码
     */
    private String code;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 请求返回结果
     */
    private String resultinfo;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 错误消息
     */
    private String errorinfo;

    private String responsecode;

    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(String resultinfo) {
        this.resultinfo = resultinfo;
    }

    public String getErrorinfo() {
        return errorinfo;
    }

    public void setErrorinfo(String errorinfo) {
        this.errorinfo = errorinfo;
    }
}
