package cn.itcast.user.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//热更新nacos的参数
@RefreshScope
@RequestMapping(value = "/file")
public class FileReadController {

    @Value("${user.age}")
    private int age;

    @GetMapping(value = "/user")
    public String user() {
        return age + " 岁！";
    }
}
