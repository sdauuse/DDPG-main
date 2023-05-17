package com.miao.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//多个过滤器  如果排序值越小，执行顺序越先（优先）
//@Order(1)
@Configuration
public class Authorizer implements GlobalFilter, Ordered {
    /***
     * 过滤方法
     * @param exchange  上下文对象   Reuqest、Response
     * @param chain  将当前请求委托给下一个过滤器
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //0）获取Request、Response对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        //1）获取当前用户请求的数据   参数|请求头  authorization
        //获取参数
        //String authorization = request.getHeaders().getFirst("authorization"); //获取请求头指定的可以的第1个值
        String authorization = request.getQueryParams().getFirst("authorization");
        //2）判断authorization是否为空，不为空，如果为admin，则放行
        if (!ObjectUtils.isEmpty(authorization) && "admin".equals(authorization)) {
            //放行，将当前请求委托给下一个过滤器
            return chain.filter(exchange);
        }
        //3）否则拦截   设置状态码

        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        //结束请求
        return response.setComplete();
    }

    //多个过滤器  如果排序值越小，执行顺序越先（优先）
    @Override
    public int getOrder() {
        return 1;
    }


}
