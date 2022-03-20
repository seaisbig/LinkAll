package kris.utils.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class operation{
    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    public static final String Queue_NAME="official_queue";
    public static void sender(String message) throws JMSException {
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
        //5.创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);
        //6.通过使用messageProducer生产3条消息发送到MQ的队列里面
        //7.创建消息
        TextMessage textMessage=session.createTextMessage(message);
        //8.通过messageProducer发送给mq
        messageProducer.send(textMessage);
        //9.释放资源
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("sender OK");
    }
    public static void getter() throws JMSException {
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
                System.out.println("message:" + textMessage.getText());
            } else {
                System.out.println("***textMessage is null***--utils.mq.activemq");
                break;
            }
        }
        messageConsumer.close();
        session.close();
        connection.close();
        System.out.println("getter OK");
    }
}
