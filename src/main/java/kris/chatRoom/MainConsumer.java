package kris.chatRoom;

public class MainConsumer {
    public static void main(String[] args) {
        JMSConsumerThread jch = new JMSConsumerThread();
        jch.init();
        jch.consumer();
    }
}