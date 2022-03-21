package kris.activemq.test.productTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ActivemqApplicationTests {
    @Autowired
    JmsComponent jmsComponent;
    @Test
    public void contextLoads() {
        Message message = new Message();
        message.setContent("hello activeMq");
        message.setSendDate(new Date());
        jmsComponent.send((javax.jms.Message) message);
    }
}