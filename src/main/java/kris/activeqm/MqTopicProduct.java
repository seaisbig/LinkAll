package kris.activeqm;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * @Author
 * @Description: IntelliJ IDEA
 * @create 2020/5/1313:20
 */
public class MqTopicProduct {

    private static final String url="tcp://127.0.0.1:61616";//服务地址，端口默认61616
    private static final String topicName="topic-test";//要创建的消息名称
    public static void main(String[] args) throws JMSException {
        //1.创建ConnectiongFactory,绑定地址
        ConnectionFactory factory=new ActiveMQConnectionFactory(url);
        //2.创建Connection
        Connection connection= factory.createConnection();
        //3.启动连接
        connection.start();
        //4.创建会话
        Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建一个目标
        Destination destination=session.createTopic(topicName);
        //6.创建一个生产者
        MessageProducer producer=session.createProducer(destination);
        for (int i = 0; i < 10000; i++) {
            //7.创建消息
            TextMessage textMessage=session.createTextMessage("i am message publisher"+i);
            //8.发送消息
            producer.send(textMessage);
            System.out.println("send message"+i);
        }
        connection.close();
    }
}
