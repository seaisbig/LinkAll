package kris.activemq.test.productTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by kris on 2022.3.20
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("jms/application.xml");
        ac.start();
        JmsTemplate jms = (JmsTemplate) ac.getBean("jmsTemplate");
        Destination destination = (Destination) ac.getBean("queueDestination");
        MessageCreator messageCreator;
        while(true){
            Scanner scanner = new Scanner(System.in);
            final String str = scanner.nextLine();
            messageCreator = session -> session.createTextMessage(str);
            jms.send(destination,messageCreator);
        }

    }
}