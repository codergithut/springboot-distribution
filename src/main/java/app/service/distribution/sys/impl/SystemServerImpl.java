package app.service.distribution.sys.impl;

import app.config.Constant;
import app.domain.entity.certificate.Distribution;
import app.domain.model.http.HttpRequestMessage;
import app.domain.model.http.HttpResponseMessage;
import app.service.distribution.sys.SystemServer;
import app.service.rabbit.send.SenderMessageTemplate;
import app.util.SymmetricEncoder;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/13
 * @description
 */
@Service
public class SystemServerImpl implements SystemServer {

    @Autowired
    SenderMessageTemplate senderMessageTemplate;

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @param
     * @return
     * @description 为请求对象添加附加信息并返回
     */
    @Override
    public HttpResponseMessage systemServer(HttpRequestMessage httpRequestMessage) {
        if(httpRequestMessage.getType().equals("distribution")) {
            HttpResponseMessage httpResponseMessage = new HttpResponseMessage();
            Distribution distribution = (Distribution) httpRequestMessage.getMessage();
            String encode = SymmetricEncoder.AESEncode(Constant.AES_KEY, distribution.getZmh());
            distribution.setPh(encode);
            httpResponseMessage.setCode("dafeng");
            httpResponseMessage.setErrorinfo(null);
            httpResponseMessage.setResponsecode("0000");
            httpResponseMessage.setResultinfo(JSON.toJSONString(distribution));
            senderMessageTemplate.senderMessage(JSON.toJSONString(httpRequestMessage.getMessage()), "distribution", "exchange");
            return httpResponseMessage;
        }
        return null;
    }

}
