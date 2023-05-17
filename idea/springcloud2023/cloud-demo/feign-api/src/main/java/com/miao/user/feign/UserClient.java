package com.miao.user.feign;

import com.miao.user.pojo.User;
import com.miao.user.config.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userservice", path = "/user", configuration = FeignClientConfiguration.class)
//熔断限流会有问题，不建议使用
//@RequestMapping(value = "/user")
public interface UserClient {

    /***
     * 指定远程调用的uri地址
     *  1）解析该对象上的注解，获取注解的value值，其实就是获取了服务名字userservice
     *  2）从注册中心中根据该服务名字获取服务可用的列表
     *          userservice:
     *              localhost:8081
     *              localhost:8082
     *              localhost:8083
     *  3）程序中如果调用该方法，则会拼接组装一个url地址
     *          A:根据服务名字从可用的服务列表中获取一个服务
     *          B:将url地址中的服务名字替换成IP:Port
     *          C:实现远程调用，Http协议
     */
    @GetMapping(value = "/{id}")
    User findById(@PathVariable("id") Long id);

}
