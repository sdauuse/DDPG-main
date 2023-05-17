package cn.itcast.mq.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SpringRabbitListener {

    // ****************************** direction *******************************
    @RabbitListener(bindings = @QueueBinding(
            //队列
            value = @Queue("topic.queue1"),
            //交换机
            exchange = @Exchange(value = "myExchange.topic", type = ExchangeTypes.TOPIC),
            //消息路由标签
            key = {"skill.core.#", "#.all"}
    ))
    public void topicListenerJava(String msg) {
        System.out.println("topic==========>>java核心部门 消费者接收到消息：【" + msg + "】");
    }


    @RabbitListener(bindings = @QueueBinding(
            //队列
            value = @Queue("topic.queue2"),
            //交换机
            exchange = @Exchange(value = "myExchange.topic", type = ExchangeTypes.TOPIC),
            //消息路由标签
            key = {"skill.other.#", "#.all"}
    ))
    public void topicListenerAndroid(String msg) {
        System.out.println("topic==========>>非核心部门 消费者接收到消息：【" + msg + "】");
    }


    // ****************************** direction *******************************
    @RabbitListener(bindings = @QueueBinding(
            //队列
            value = @Queue("direct.queue1"),
            //交换机
            exchange = @Exchange(value = "myExchange.direct", type = ExchangeTypes.DIRECT),
            //消息路由标签
            key = {"android", "skill"}
    ))
    public void directListenerAndroid(String msg) {
        System.out.println("direct==========>>android 消费者接收到消息：【" + msg + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            //队列
            value = @Queue("direct.queue2"),
            //交换机
            exchange = @Exchange(value = "myExchange.direct", type = ExchangeTypes.DIRECT),
            //消息路由标签
            key = {"java", "skill"}
    ))
    public void directListenerJava(String msg) {
        System.out.println("direct==========>>java 消费者接收到消息：【" + msg + "】");
    }

    // ****************************** work *******************************
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage(String msg) throws InterruptedException {
        System.out.println("consumer==========>>1111111 spring 消费者接收到消息：【" + msg + "】");
    }

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage2(String msg) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("consumer==========>>2222222 spring 消费者接收到消息：【" + msg + "】");
    }

    // ****************************** fanout *******************************
    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueueMessage1(String msg) {
        System.out.println("消费者1接收到Fanout消息：【" + msg + "】");
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueueMessage2(String msg) {
        System.out.println("消费者2接收到Fanout消息：【" + msg + "】");
    }
}
