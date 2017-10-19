package app.controller;

import app.domain.model.http.HttpRequestMessage;
import app.service.distribution.sys.SystemServer;
import com.alibaba.fastjson.JSONObject;
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

    @RequestMapping(value = "distribution", method = RequestMethod.GET)
    public String distributionServer(String content) throws IOException, TimeoutException {
        HttpRequestMessage httpRequestMessage = new HttpRequestMessage();
        httpRequestMessage.setCode("0000");
        httpRequestMessage.setType("distribution");
        httpRequestMessage.setMessage(content);
        httpRequestMessage.setName("dafeng");
        return JSONObject.toJSONString(systemServer.distributionServer(httpRequestMessage));
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
