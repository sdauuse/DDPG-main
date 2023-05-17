package com.hmall.order.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * jwt 令牌工具
 */
public class JwtUtil {

    //秘钥
    private final static String SIGNATURE = "miaoyin";

    /****
     * 创建令牌  创建一段别人不知道密文【字符串->JWT格式的字符串】   JLjdslfdsfLKJlddsfsd . IJlkndslfnNdsf . IOJLKNLSDFdsfsdf
     *          header : 头部   base64编码                abc -> Base64 -> sdfDSFdsf -> Base64 ->abc
     *                  {
     *                      "alg":"MD5",
     *                      "type":"jwt"
     *                  }
     *          payload  ： 载荷  base64编码
     *          Signature  ： 签名  很安全
     *
     *                      额外字符串：秘钥  itheima{自己知道，不会公开}
     *                      header : JLjdslfdsfLKJlddsfsd
     *                      payload : IJlkndslfnNdsf
     *
     *                      加密-> MD5(header+payload+秘钥)->LKJKLSDNLSDLFJSODJFIOSUIOF
     *
     * @return
     */
    public static String token(Map<String, Object> dataMap) {
        //使用JWT自带的构造器构造一个jwt
        JwtBuilder builder = Jwts.builder();
        //使用构造器里的方法封装属性
        String token = builder
                //封装header属性
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")  //指定  Signature加密算法
                //封装payload里的信息 使用claim方法
                .setClaims(dataMap)
                //在payLoad中设置一个超时时间  秒   分 时
                .setExpiration(new Date(System.currentTimeMillis() + Long.valueOf(10000000 * 60 * 60 * 1)))
                .setId(UUID.randomUUID().toString())
                //构造signature部分
                .signWith(SignatureAlgorithm.HS256, SIGNATURE)
                //构造我们的签名 调用compact方法
                .compact();
        return token;
    }

    /***
     * 令牌解析
     * @param token
     * @return
     */
    public static Map<String, Object> parse(String token) {
        //解密
        JwtParser parser = Jwts.parser();
        Jws<Claims> claimsJws = parser.setSigningKey(SIGNATURE).parseClaimsJws(token);
        return claimsJws.getBody();
    }

    public static void main(String[] args) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("username", "张三");
        dataMap.put("age", 23);
        String token = token(dataMap);
        System.out.println(token);

        Map<String, Object> parse = parse(token);
        System.out.println(parse);
    }
}
