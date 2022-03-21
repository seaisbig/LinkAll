package kris.Product;

import kris.utils.mq.activemq.operation;

import javax.jms.JMSException;

public class Bside {
    public static void main(String[] args) throws JMSException {
        operation.getter();
    }
}
