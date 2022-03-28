package kris.Product;

import kris.utils.jdbc.mysql.setIn;
import kris.utils.mq.activemq.operation;

import javax.jms.JMSException;
import java.sql.SQLException;

public class Bside {
    public static void main(String[] args) throws JMSException, SQLException {
        operation.getter();
        setIn.set("");
    }
    public static void insert(int x){

    }

}
