package kris.activemq.test.utilsTest;

import kris.utils.mq.activemq.operation;

import javax.jms.JMSException;
import java.io.IOException;

public class utilsTest {
    public static void main(String[] args) throws JMSException, IOException {
        operation.sender("hello world");
        operation.getter();
    }
}
