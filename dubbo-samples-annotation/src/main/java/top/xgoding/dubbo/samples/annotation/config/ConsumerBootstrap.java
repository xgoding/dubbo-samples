package top.xgoding.dubbo.samples.annotation.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import top.xgoding.dubbo.samples.annotation.action.GreetingServiceConsumer;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.annotation.config
 * @description:
 * @author: yxguang
 * @date: 2020/11/23
 * @version: V1.0
 * @modified: yxguang
 */
public class ConsumerBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        GreetingServiceConsumer bean = context.getBean(GreetingServiceConsumer.class);
        bean.sayHello("xgoding");
        bean.sayHelloV1("xgoding");
        bean.sayHelloV2("xgoding");
        bean.sayHelloGd("xgoding");
        bean.sayHelloZh("xgoding");
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "top.xgoding.dubbo.samples.annotation.action")
    @ComponentScan(basePackages = "top.xgoding.dubbo.samples.annotation.action")
    @PropertySource(value = {"classpath:spring/dubbo-consumer.properties"})
    public static class ConsumerConfiguration {

    }
}
