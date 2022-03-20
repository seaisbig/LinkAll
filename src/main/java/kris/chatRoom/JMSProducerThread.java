package kris.chatRoom;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * 消息生产者-消息发布者(多线程发送)
 **/
public class JMSProducerThread {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址
    private static final int SENDNUM = 10; // 发送的消息数量
    ConnectionFactory connectionFactory = null; // 连接工厂
    private Connection connection = null;

    public void init() {
// 实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(JMSProducerThread.USERNAME, JMSProducerThread.PASSWORD, JMSProducerThread.BROKEURL);
        try {
            connection = connectionFactory.createConnection(); // 通过连接工厂获取连接
            connection.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    public void produce() {
        try {
            MessageProducer messageProducer; // 消息生产者
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE); // 创建Session
            // 消息的目的地
            Destination destination = session.createQueue("queue1");
            messageProducer = session.createProducer(destination); // 创建消息生产者
            for (int i = 0; i < SENDNUM; i++) {
                TextMessage message = session.createTextMessage("ActiveMQ中" + Thread.currentThread().getName() + "线程发送的数据" + ":" + i);
                System.out.println(Thread.currentThread().getName() + "线程" + "发送消息：" + "ActiveMQ 发布的消息" + ":" + i);
                messageProducer.send(message);
                session.commit();
            }
        } catch (JMSException jmsException) {
            jmsException.printStackTrace();
        }
    }
    /*发送消息*/
    public static void sendMessage(Session session,MessageProducer messageProducer)throws Exception {
                for (int i = 0; i < SENDNUM; i++) {
                    TextMessage message = session.createTextMessage("ActiveMQ 发送的消息" + i);
                    System.out.println("发送消息：" + "ActiveMQ 发布的消息" + i);
                    messageProducer.send(message);
                }
    }
}