package com.miao;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-13
 * @Copyright：
 */
import com.alibaba.fastjson.JSON;
import com.zhipu.oapi.ClientV4;
import com.zhipu.oapi.Constants;
import com.zhipu.oapi.core.httpclient.ApacheHttpClientTransport;
import com.zhipu.oapi.service.v4.model.*;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiTest {
    private static final String API_KEY = "38c90131d5e1af9ce4556d74fa69c374.07ZnFod1t510PBwO";
    // 请自定义自己的业务id
    private static final String requestIdTemplate = "mycompany-%d";
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        https://api.zsxq.com/v2/topics/4844852151158848/comments?sort=asc&count=30&with_sticky=true
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/topics/4844852151158848/comments?sort=asc&count=30&with_sticky=true");

        get.addHeader("cookie","sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218cf6f6666881-0045bdd71fd0cda4-67025e53-1327104-18cf6f666699d0%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fbugstack.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjZjZmNjY2Njg4MS0wMDQ1YmRkNzFmZDBjZGE0LTY3MDI1ZTUzLTEzMjcxMDQtMThjZjZmNjY2Njk5ZDAifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218cf6f6666881-0045bdd71fd0cda4-67025e53-1327104-18cf6f666699d0%22%7D; abtest_env=product; zsxq_access_token=2B55DDA4-54E0-AAA3-D93D-40810E522A9E_0A26DBF6AC7D4581; zsxqsessionid=36d29c0946f78bc2506157a26c821c7b");

        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        https://api.zsxq.com/v2/topics/4844852151158848/comments
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/4844852151158848/comments");
        post.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218cf6f6666881-0045bdd71fd0cda4-67025e53-1327104-18cf6f666699d0%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fbugstack.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjZjZmNjY2Njg4MS0wMDQ1YmRkNzFmZDBjZGE0LTY3MDI1ZTUzLTEzMjcxMDQtMThjZjZmNjY2Njk5ZDAifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218cf6f6666881-0045bdd71fd0cda4-67025e53-1327104-18cf6f666699d0%22%7D; abtest_env=product; zsxq_access_token=2B55DDA4-54E0-AAA3-D93D-40810E522A9E_0A26DBF6AC7D4581; zsxqsessionid=36d29c0946f78bc2506157a26c821c7b");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void testVirtual(){
        //ClientV4 client = new ClientV4.Builder("{Your ApiKey}", "Your ApiSecret")
        //            .httpTransport(new ApacheHttpClientTransport())// 传输层默认使用okhttpclient，如果需要修改位其他http client（如apache），可以在这里指定。注意apache不支持sse调用
        //            .build();
        ClientV4 client = new ClientV4.Builder(API_KEY)
                .build();
        System.out.println(client);


        // 建议直接查看demo包代码，这里更新可能不及时
        List<ChatMessage> messages = new ArrayList<>();
        ChatMessage chatMessage = new ChatMessage(ChatMessageRole.USER.value(), "ChatGLM和你哪个更强大");
        messages.add(chatMessage);
        String requestId = String.format(requestIdTemplate, System.currentTimeMillis());
        List<ChatTool> chatToolList = new ArrayList<>();
        ChatTool chatTool = new ChatTool();
        chatTool.setType(ChatToolType.FUNCTION.value());
        ChatFunctionParameters chatFunctionParameters = new ChatFunctionParameters();
        chatFunctionParameters.setType("object");
        Map<String,Object> properties = new HashMap<>();
        properties.put("location",new HashMap<String,Object>(){{
            put("type","string");
            put("description","城市，如：北京");
        }});
        properties.put("unit",new HashMap<String,Object>(){{
            put("type","string");
            put("enum",new ArrayList<String>(){{add("celsius");add("fahrenheit");}});
        }});
        chatFunctionParameters.setProperties(properties);
        ChatFunction chatFunction = ChatFunction.builder()
                .name("get_weather")
                .description("Get the current weather of a location")
                .parameters(chatFunctionParameters)
                .build();
        chatTool.setFunction(chatFunction);
        chatToolList.add(chatTool);

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model(Constants.ModelChatGLM4)
                .stream(Boolean.TRUE)
                .messages(messages)
                .requestId(requestId)
                .tools(chatToolList)
                .toolChoice("auto")
                .build();
        ModelApiResponse sseModelApiResp = client.invokeModelApi(chatCompletionRequest);
        System.out.println("model output:"+ JSON.toJSONString(sseModelApiResp));
    }


}
