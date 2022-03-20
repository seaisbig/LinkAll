package kris.chatRoom;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
//消息监听(多线程接收)
public class Listener3 implements MessageListener{
    private final ExecutorService threadPool =Executors.newFixedThreadPool(8);
    @Override
    public void onMessage(final Message message) {
        threadPool.execute(() -> {
            try {
                try {
                    Thread.sleep(new Random().nextInt(2)*500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("接收线程..."+Thread.currentThread().getName()+"收到的消息是："+((TextMessage)message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
    }
}