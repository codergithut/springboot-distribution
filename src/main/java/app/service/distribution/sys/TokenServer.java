package app.service.distribution.sys;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/20
 * @description
 */
public interface TokenServer {
    boolean checkToken(String token);
}
