package kris.log;

import org.apache.log4j.Logger;

public class Log4jTest {
    /**
     * 日志:打印=位置参考log4j.properties
     */
    private final Logger logger = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        new Log4jTest().printTestLog();
    }

    public void printTestLog(){
        //debug级别的日志
        logger.debug("this is a debug log");

        //info级别的日志
        logger.info("this is a info log");

        //warn级别的日志
        logger.warn("this is a warn log");


        //error级别的日志
        logger.error("this is a error log",new RuntimeException());

        /**
         * 备注：
         * 看你当前项目在C、D、E还是F盘，然后查看对应盘符下的/data/logs/ssmTest/common/common.log 是否有写入日志信息<br/>
         * 查看对应盘符下的/data/logs/ssmTest/error/error.log 是否有写入错误日志信息
         */
    }

}