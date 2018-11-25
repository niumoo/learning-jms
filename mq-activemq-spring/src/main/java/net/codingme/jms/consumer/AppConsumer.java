package net.codingme.jms.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * 消费者启动器
 *
 * @Author niujinpeng
 * @Date 2018/11/25 22:33
 */
public class AppConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    }
}
