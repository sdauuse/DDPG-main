package com.miao.user.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignClientConfiguration {

    /***
     * 定义日志级别
     */
    @Bean
    public Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}
