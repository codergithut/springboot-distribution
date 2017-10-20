package app.service.distribution.sys.impl;

import app.service.distribution.sys.TokenServer;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/20
 * @description
 */
@Service
public class TokenServerImpl implements TokenServer {

    @Override
    public boolean checkToken(String token) {
        return true;
    }
}
