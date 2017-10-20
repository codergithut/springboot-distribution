package app.controller;

import app.domain.entity.Distribution;
import app.domain.model.http.HttpRequestMessage;
import app.domain.model.http.HttpResponseMessage;
import app.service.distribution.sys.SystemServer;
import app.service.distribution.sys.TokenServer;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/13
 * @description 系统配号逻辑控制
 */
@RestController
@EnableAutoConfiguration
public class Example {

    @Autowired
    SystemServer systemServer;

    @Autowired
    TokenServer tokenServer;

    @RequestMapping(value = "distribution", method = RequestMethod.GET)
    public String distributionServer(Distribution distribution, String token) throws IOException, TimeoutException {
        HttpRequestMessage httpRequestMessage = new HttpRequestMessage();

        HttpResponseMessage httpResponseMessage = null;

        if(!tokenServer.checkToken(token)) {
            httpResponseMessage = new HttpResponseMessage();
            httpResponseMessage.setResultinfo("token is wrong");
            httpResponseMessage.setCode("0001");
            return JSON.toJSONString(httpResponseMessage);
        } else {
            httpRequestMessage.setType("distribution");
            httpRequestMessage.setToken(token);
            httpRequestMessage.setMessage(distribution);
            httpResponseMessage = systemServer.systemServer(httpRequestMessage);
            return JSON.toJSONString(httpResponseMessage);
        }
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
