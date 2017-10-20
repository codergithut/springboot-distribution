package app.service.distribution.sys;

import app.domain.model.http.HttpRequestMessage;
import app.domain.model.http.HttpResponseMessage;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/13
 * @description
 */
public interface SystemServer {

    HttpResponseMessage systemServer(HttpRequestMessage httpRequestMessage);

}
