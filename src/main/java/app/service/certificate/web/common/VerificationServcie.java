package app.service.certificate.web.common;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/18
 * @description
 */
public interface VerificationServcie {

    /**
     * @param
     * @return
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 检查该证书印刷号是否存在（导入空白的证书号看是否在其中）
     */
    boolean checkCertificateIsExist();

    /**
     * @param
     * @return
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 检查导入的证书和数据已存的数据是否一致
     */
    boolean checkCertificateConsistency();

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @param
     * @return
     * @description 到导入数据库和上传库中检查是否唯一，正确的情况是导入库不存在记录，上传库中存在唯一一条记录
     */
    boolean checkDubleCertificate();


}
