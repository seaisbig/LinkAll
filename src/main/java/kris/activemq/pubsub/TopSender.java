package kris.activemq.pubsub;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * 消息发送者
 * @author kris
 *
 */
public class TopSender {
    private static final String BROKERURL = "tcp://127.0.0.1:61616";
    private static final String TOPIC = "official_queue";

    public static void main(String[] args) throws JMSException {
        start();
    }

    static public void start() throws JMSException {
        System.out.println("consumer is open....");
        // 创建ActiveMQConnectionFactory 会话工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, BROKERURL);
        Connection connection = activeMQConnectionFactory.createConnection();
        // 启动JMS 连接
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(null);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        send(producer, session);
        System.out.println("send success!");
        connection.close();
    }

    static public void send(MessageProducer producer, Session session) throws JMSException {
        for (int i = 1; i <= 5; i++) {
            System.out.println("i am message" + i);
            TextMessage textMessage = session.createTextMessage("i am message" + i);
            Destination destination = session.createTopic(TOPIC);
            producer.send(destination, textMessage);
        }
    }
}