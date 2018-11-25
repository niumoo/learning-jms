package net.codingme.jms.producer;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * 启动器
 *
 * @Author niujinpeng
 * @Date 2018/11/25 21:48
 */
public class AppProducer {

    public static void main(String[] args) {
        // 装载配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:producer.xml");
        ProducerService service = context.getBean(ProducerService.class);

        for (int i = 0; i < 10; i++) {
            service.sendMessage("test" + i);
        }
        context.close();
    }

}
