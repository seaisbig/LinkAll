package kris.activemq.test.productTest;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
    public class QueueBean{
        //创建一个队列实例
        @Bean
        Queue queue(){
            //这里设置的消息是队列的名称
            return new ActiveMQQueue("hello.javaboy");
        }
    }

