package app.domain.entity.certificate;

import java.util.Date;

/**
 * @author <a href="mailto:tianjian@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/17
 * @description
 */
public class PurchaseHistory {

    private String id;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 行政区
     */
    private String xzq;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 购买时间
     */
    private Date gmsj;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 证书类型
     */
    private String zslx;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 起始编号
     */
    private String qsbh;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 结束编号
     */
    private String jsbh;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 上报人
     */
    private String sbr;

    public String getXzq() {
        return xzq;
    }

    public void setXzq(String xzq) {
        this.xzq = xzq;
    }

    public Date getGmsj() {
        return gmsj;
    }

    public void setGmsj(Date gmsj) {
        this.gmsj = gmsj;
    }

    public String getZslx() {
        return zslx;
    }

    public void setZslx(String zslx) {
        this.zslx = zslx;
    }

    public String getQsbh() {
        return qsbh;
    }

    public void setQsbh(String qsbh) {
        this.qsbh = qsbh;
    }

    public String getJsbh() {
        return jsbh;
    }

    public void setJsbh(String jsbh) {
        this.jsbh = jsbh;
    }

    public String getSbr() {
        return sbr;
    }

    public void setSbr(String sbr) {
        this.sbr = sbr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
