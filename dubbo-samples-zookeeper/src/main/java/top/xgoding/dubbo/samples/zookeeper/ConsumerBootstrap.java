package top.xgoding.dubbo.samples.zookeeper;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.container.spring.SpringContainer;
import org.springframework.context.annotation.*;
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
    @ComponentScan(basePackages = "top.xgoding.dubbo.samples.zookeeper.action")
    @PropertySource(value = {"classpath:/spring/dubbo-consumer.properties"})
    public static class ConsumerConfig {

    }
}
