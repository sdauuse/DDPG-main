package com.hmall.listener;

import com.hmall.item.pojo.Item;
import com.hmall.search.service.SearchService;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemListenerSync {
    @Autowired
    private SearchService searchService;



    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("itemQueue"),
            exchange = @Exchange(value = "itemEsExchange", type = ExchangeTypes.DIRECT),
            key = {"item.modify"}
    ))
    public void itemSync(Item item){


        searchService.sync(item);
    }
}
