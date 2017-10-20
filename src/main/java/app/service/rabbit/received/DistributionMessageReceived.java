package app.service.rabbit.received;

import app.domain.entity.Distribution;
import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/20
 * @description
 */
@Component
public class DistributionMessageReceived {

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @description 消息消费，这边需要实现配号跟新或插入操作
     */
    @RabbitListener(queues = "distribution")
    public void processMessage(byte[] content) throws UnsupportedEncodingException {
        String o = new String(content, "UTF-8");
        Distribution distribution = JSON.parseObject(o, Distribution.class);
        System.out.println(distribution.getQzysxlh());
        //todo 将数据封装下给东西消费
    }
}
