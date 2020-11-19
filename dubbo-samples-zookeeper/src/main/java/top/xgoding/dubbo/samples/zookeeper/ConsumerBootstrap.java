package top.xgoding.dubbo.samples.zookeeper;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import top.xgoding.dubbo.samples.zookeeper.action.GreetingConsumer;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.zookeeper
 * @description:
 * @author: yxguang
 * @date: 2020/11/19
 * @version: V1.0
 * @modified: yxguang
 */
public class ConsumerBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfig.class);
        context.start();
        GreetingConsumer consumer = context.getBean(GreetingConsumer.class);
        String greeting = consumer.greeting("greeting");
        System.out.println("Greeting from server: " + greeting);
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "top.xgoding.dubbo.samples.zookeeper.action")
    @ComponentScan(basePackages = "top.xgoding.dubbo.samples.zookeeper")
    @PropertySource(value = "classpath:/spring/dubbo-consumer.properties")
    public static class ConsumerConfig {

    }
}
