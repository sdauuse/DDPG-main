package com.hmall.filter;

import com.hmall.utils.JwtUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

public class UserInfoFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String uri = request.getURI().getPath();
        //放行登录
        if (uri.contains("/login")) {
            return chain.filter(exchange);
        }

        String authorization = request.getHeaders().getFirst("authorization");


        //如果有jwt令牌，且令牌没有问题，则放行
        if (!ObjectUtils.isEmpty(authorization)) {
            if (JwtUtil.parse(authorization) != null) {
                return chain.filter(exchange);
            }
        }
        //上述条件不成立则拦截
        //设置状态码
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
        return response.writeWith(Mono.just(response.bufferFactory().wrap("请先登录".getBytes(StandardCharsets.UTF_8))));
    }
}
