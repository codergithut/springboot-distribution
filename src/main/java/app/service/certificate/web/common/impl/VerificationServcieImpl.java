package app.service.certificate.web.common.impl;

import app.service.certificate.web.common.VerificationServcie;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/20
 * @description
 */
@Service
public class VerificationServcieImpl implements VerificationServcie {
    @Override
    public boolean checkCertificateIsExist() {
        return false;
    }

    @Override
    public boolean checkCertificateConsistency() {
        return false;
    }

    @Override
    public boolean checkDubleCertificate() {
        return false;
    }
}
