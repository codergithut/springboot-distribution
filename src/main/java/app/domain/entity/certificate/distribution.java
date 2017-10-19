package app.domain.entity.certificate;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/19
 * @description
 */
public class distribution {

    private String id;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 行政区
     */
    private String xzq;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 证书印刷流水号
     */
    private String yslsh;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 证书类型
     */
    private String zslx;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 不动产单元号
     */
    private String bdcqzh;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 配号
     */
    private String ph;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYslsh() {
        return yslsh;
    }

    public void setYslsh(String yslsh) {
        this.yslsh = yslsh;
    }

    public String getZslx() {
        return zslx;
    }

    public void setZslx(String zslx) {
        this.zslx = zslx;
    }

    public String getBdcqzh() {
        return bdcqzh;
    }

    public void setBdcqzh(String bdcqzh) {
        this.bdcqzh = bdcqzh;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getXzq() {
        return xzq;
    }

    public void setXzq(String xzq) {
        this.xzq = xzq;
    }
}
