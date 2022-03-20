package kris.activemq.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class exampleofConsumer {
    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    public static final String Queue_NAME="queue01";
    public static void main(String[] args) throws JMSException {
        //1.创建连接工厂,按照给定的url地址,采用默认的用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.通过连接工厂，获得连接connection并启动访问
        Connection connection=activeMQConnectionFactory.createConnection();
        connection.start();
        //3.创建会话session
        //两个参数，第一个叫事务/第二个叫签收
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地(具体是队列还是主题topic)
        Queue queue =session.createQueue(Queue_NAME);//Connection connection =new Arraylist
        //5.创建消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);
        while(true) {
            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            if (null != textMessage) {
                System.out.println("consumer get message:" + textMessage.getText());
            } else {
                break;
            }
        }
        messageConsumer.close();
        session.close();
        connection.close();
        System.out.println("message get OK");
    }
}
