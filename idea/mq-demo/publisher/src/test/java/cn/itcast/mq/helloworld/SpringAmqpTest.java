package cn.itcast.mq.helloworld;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSimpleQueue() {
        // 队列名称
        String queueName = "simple.queue";
        // 消息
        String message = "hello, spring amqp!";
        // 发送消息
        for (int i = 1; i <= 10; i++) {

            rabbitTemplate.convertAndSend(queueName, message + i);
        }
    }

    @Test
    public void testFanoutExchange() {
        // 队列名称
        String exchangeName = "my.FanoutExchange";
        // 消息
        String message = "hello, everyone!";
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }

    @Test
    public void testDirectExchange() {
        // 队列名称
        String exchangeName = "myExchange.direct";
        // 消息
        String messageAndroid = "安卓全体会议!";
        String messageJava = "java组全体会议";
        String messageSkill = "技术组全体会议";
        rabbitTemplate.convertAndSend(exchangeName, "android", messageAndroid);
        rabbitTemplate.convertAndSend(exchangeName, "java", messageJava);
        rabbitTemplate.convertAndSend(exchangeName, "skill", messageSkill);
    }

    @Test
    public void testTopicExchange() {
        // 队列名称
        String exchangeName = "myExchange.topic";
        // 消息
        String messageCore = "核心组发年终奖！";
        String messageOther = "非核心组新年快乐！";
        String messageAll = "所有组新年快乐！";
        rabbitTemplate.convertAndSend(exchangeName, "skill.core.java", messageCore);
        rabbitTemplate.convertAndSend(exchangeName, "skill.other", messageOther);
        rabbitTemplate.convertAndSend(exchangeName, "skill.all", messageAll);
    }
}
