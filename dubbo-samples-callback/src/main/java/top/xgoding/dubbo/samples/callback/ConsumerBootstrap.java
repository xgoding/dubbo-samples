package top.xgoding.dubbo.samples.callback;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import top.xgoding.dubbo.samples.callback.action.CallbackConsumer;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.callback
 * @description:
 * @author: yxguang
 * @date: 2020/11/30
 * @version: V1.0
 * @modified: yxguang
 */
public class ConsumerBootstrap {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfig.class);
        context.start();
        CallbackConsumer consumer = context.getBean(CallbackConsumer.class);
        consumer.addListener();
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "top.xgoding.dubbo.samples.callback.action")
    @ComponentScan(basePackages = "top.xgoding.dubbo.samples.callback.action")
    public static class ConsumerConfig {
        @Bean
        ApplicationConfig applicationConfig() {
            ApplicationConfig config = new ApplicationConfig("dubbo-callback-consumer");
            return config;
        }

        @Bean
        RegistryConfig registryConfig() {
            RegistryConfig config = new RegistryConfig();
            config.setAddress("zookeeper://127.0.0.1:2181");
            return config;
        }
    }
}
