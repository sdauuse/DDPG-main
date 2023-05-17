package cn.itcast.hotel.listener;

import cn.itcast.hotel.pojo.Hotel;
import cn.itcast.hotel.pojo.HotelDoc;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitHotelListener {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /***
     * 增加酒店数据监听
     *  1)创建队列
     *  2)创建交换机
     *  3)绑定
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "hotel.insert.queue"),
            exchange = @Exchange(value = "hotel.topic",type = ExchangeTypes.TOPIC),
            key = {"hotel.insert"}
    ))
    public void insertListener(Hotel hotel) throws IOException {
        IndexRequest request = new IndexRequest("hotel").id(hotel.getId().toString());
        String json = JSON.toJSONString(new HotelDoc(hotel));
        request.source(json, XContentType.JSON);
        restHighLevelClient.index(request, RequestOptions.DEFAULT);
    }

    /***
     * 删除酒店数据监听
     *  1)创建队列
     *  2)创建交换机
     *  3)绑定
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "hotel.delete.queue"),
            exchange = @Exchange(value = "hotel.topic",type = ExchangeTypes.TOPIC),
            key = {"hotel.delete"}
    ))
    public void deleteListener(Long id) throws IOException {
        DeleteRequest request = new DeleteRequest("hotel").id(id.toString());
        restHighLevelClient.delete(request, RequestOptions.DEFAULT);
    }
}
