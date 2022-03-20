package kris.activemq.test.productTest;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by kris
 */
public class ActiveMQListener implements MessageListener{
    public void onMessage(Message message) {
        //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换，或者直接把onMessage方法的参数改成Message的子类TextMessage
        if (message instanceof TextMessage textMsg) {
            try {
                System.out.println("message comes from:"+textMsg.getJMSDestination()+"message:：" + textMsg.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("ActiveMQ message types wrong+"+message);
        }
    }
}