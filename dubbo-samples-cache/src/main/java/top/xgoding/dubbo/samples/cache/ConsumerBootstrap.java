package top.xgoding.dubbo.samples.cache;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import top.xgoding.dubbo.samples.cache.action.GreetingConsumer;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.attachement
 * @description:
 * @author: yxguang
 * @date: 2020/11/27
 * @version: V1.0
 * @modified: yxguang
 */
public class ConsumerBootstrap {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfig.class);
        context.start();
        GreetingConsumer consumer = context.getBean(GreetingConsumer.class);
        consumer.sayHi("xgoding");
        consumer.sayHi("xgoding");
        consumer.sayHi("xgoding");
        consumer.goodbye("xgoding");
        consumer.goodbye("xgoding");
        consumer.goodbye("xgoding2");
        consumer.goodbye("xgoding2");
    }
    @ComponentScan(basePackages = "top.xgoding.dubbo.samples.cache.action")
    @EnableDubbo(scanBasePackages = "top.xgoding.dubbo.samples.cache.action")
    public static class ConsumerConfig {

        @Bean
        ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("dubbo-cache-consumer");
            return applicationConfig;
        }

        @Bean
        RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress("zookeeper://127.0.0.1:2181");
            return registryConfig;
        }
    }
}
