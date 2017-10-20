package app.domain.entity.certificate;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/19
 * @description
 */
public class Distribution {

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 权证印刷序列号
     */
    private String qzysxlh;


    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 证明号（作为生成唯一码的标志）
     */
    private String zmh;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 配号
     */
    private String ph;

    public String getQzysxlh() {
        return qzysxlh;
    }

    public void setQzysxlh(String qzysxlh) {
        this.qzysxlh = qzysxlh;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getZmh() {
        return zmh;
    }

    public void setZmh(String zmh) {
        this.zmh = zmh;
    }
}
