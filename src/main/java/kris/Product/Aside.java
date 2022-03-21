package kris.Product;

import kris.utils.io.outputFile.printFile;
import kris.utils.io.readFile.readFile;
import kris.utils.mq.activemq.operation;

import javax.jms.JMSException;
import java.util.Scanner;

public class Aside {
    public static void main(String[] args) throws JMSException {
        Scanner sc=new Scanner(System.in);
        String path="F:/note/linkAll_text.txt";
        System.out.println("the file content:"+path);
        String fileContent=readFile.getFile(path);
        System.out.println("read success!FileContent:"+fileContent);
        operation.sender(fileContent);
    }
}
