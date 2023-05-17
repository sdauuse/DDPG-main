package com.miao;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
@SuppressWarnings("all")
public class HttpGetConfigTest {
    public static void main(String[] args) {
        //1. 打开浏览器，创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.输入网址
        HttpGet httpGet = new HttpGet("https://www.itcast.cn/");

        //配置请求信息
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(2000) //创建连接的最长时间，单位为毫秒
                .setConnectionRequestTimeout(1000) //设置获取连接的最长时间，单位为毫秒
                .setSocketTimeout(10 * 1000)  //设置数据传输的最长时间，单位为毫秒
                .build();

        //给请求添加请求信息
        httpGet.setConfig(requestConfig);

        //3.按回车，发起请求，返回响应
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity, "utf8");

                System.out.println(content.length());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //4.解析响应，获取数据
        //判断状态码是否是200
    }
}
