package net.codingme.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * <p>
 * 消息提供者，用于向消息中间件发送消息
 *
 * @Author niujinpeng
 * @Date 2018/9/4 23:28
 */
public class AppProducer {

    private static final String url = "tcp://127.0.0.1:61616";
    private static final String queueName = "queue-test";

    public static void main(String[] args) throws JMSException {
        // 1.创建ConnectionFactory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        // 2.创建Connection
        Connection connection = connectionFactory.createConnection();
        // 3.启动连接
        connection.start();

        // 4.创建会话,false，不使用事务，自动应答模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5.创建一个目标
        Destination destination = session.createQueue(queueName);
        // 6.创建生产者
        MessageProducer producer = session.createProducer(destination);

        // 7.创建消息并发送
        for (int i = 0; i < 10; i++) {
            // 创建消息
            TextMessage textMessage = session.createTextMessage("textMessage" + i);
            // 发布消息
            producer.send(textMessage);
            System.out.println("发送消息：" + textMessage.getText());
        }

        // 8.关闭连接
        connection.close();

    }
}
