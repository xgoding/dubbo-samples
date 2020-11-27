package top.xgoding.dubbo.samples.attachement;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import top.xgoding.dubbo.samples.attachement.action.GreetingConsumer;

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
        //设置隐式参数，调用完成后参数会消失，下次调用还需设置参数
        RpcContext.getContext().setAttachment("name", "xgoding");
        //远程调用，服务端获取参数
        consumer.sayHi("xgoding");
        Thread.sleep(1000);
        //上次设置的隐式参数消失
        consumer.sayHi("xgoding");
    }
    @ComponentScan(basePackages = "top.xgoding.dubbo.samples.attachement.action")
    @EnableDubbo(scanBasePackages = "top.xgoding.dubbo.samples.attachement.action")
    public static class ConsumerConfig {

        @Bean
        ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("dubbo-attachement-consumer");
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
