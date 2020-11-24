package top.xgoding.dubbo.samples.annotation.annotation;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import top.xgoding.dubbo.samples.annotation.action.GreetingServiceConsumer;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.annotation.annotation
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
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "top.xgoding.dubbo.samples.annotation.action")
    @ComponentScan(basePackages = "top.xgoding.dubbo.samples.annotation.action")
    public static class ConsumerConfiguration{

        @Bean
        ApplicationConfig applicationConfig() {
            ApplicationConfig config = new ApplicationConfig();
            config.setName("consumer-annotation");
            return config;
        }

        @Bean
        RegistryConfig registryConfig() {
            RegistryConfig config = new RegistryConfig();
            config.setAddress("zookeeper://127.0.0.1:2181");
            return config;
        }

        @Bean
        public ConsumerConfig consumerConfig() {
            ConsumerConfig consumerConfig = new ConsumerConfig();
            consumerConfig.setTimeout(3000);
            return consumerConfig;
        }
    }
}
