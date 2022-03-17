package kris.activeqm;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * @Author Administrator
 * @Description: IntelliJ IDEA
 * @create 2020/5/1313:18
 */
public class MqTopicConsumer {

    private static final String url="tcp://127.0.0.1:61616";//端口默认
    private static final String topicName="topic-test";//要消费的消息名称
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
        //6.创建一个消费者
        MessageConsumer consumer=session.createConsumer(destination);
        //7.创建一个监听器
        consumer.setMessageListener(arg0 -> {
            TextMessage textMessage=(TextMessage)arg0;
            try {
                System.out.println("get message:"+textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
    }
}
