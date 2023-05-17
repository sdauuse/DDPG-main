package cn.itcast.order.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "/message")
public class MessageController {

    /***
     * @RefreshcScope结合@Value注解一起刷新数据
     */
    @Value("${message.key}")
    private String key;

    /***
     * 读取配置文件
     */
    @GetMapping(value = "/key")
    public String key() {
        return "秘钥： " + key;
    }
}
