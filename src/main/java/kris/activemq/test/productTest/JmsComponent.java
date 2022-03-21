package kris.activemq.test.productTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.Queue;

@Component
public class JmsComponent{
    //springboot提供的消息模板
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
    //自己创建的队列实例
    @Autowired
    Queue queue;
    /**
     * 发送消息
     */
    public void send(Message message){
        jmsMessagingTemplate.convertAndSend(this.queue,message);
    }
    /**
     * 接收消息
     */
    //表示监听该队列名称发来的消息
    @JmsListener(destination = "hello.javaboy")
    public void readMessage(Message message){
        System.out.println(message);
    }
}