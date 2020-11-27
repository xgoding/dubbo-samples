package top.xgoding.dubbo.samples.async;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import top.xgoding.dubbo.samples.async.action.GreetingConsumer;

import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.async
 * @description:
 * @author: yxguang
 * @date: 2020/11/23
 * @version: V1.0
 * @modified: yxguang
 */
public class ConsumerBootstrap {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfig.class);
        context.start();
        GreetingConsumer consumer = context.getBean(GreetingConsumer.class);
        consumer.syncCallAsyncSayHello("xgoding");
        Thread.sleep(1000);
        consumer.syncCallAsyncSayHello("xgoding", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Async consumer ret : " + s);
            }
        });
        Thread.sleep(2000);
        consumer.syncCallAsyncGoodBye("xgoding");
        Thread.sleep(2000);
        consumer.asyncCallSyncSayHello();
        Thread.sleep(2000);
        consumer.asyncCallSyncSayHello2();
        Thread.sleep(2000);
        consumer.asyncCallSyncGoodbye();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "top.xgoding.dubbo.samples.async.action")
    @PropertySource(value = "classpath:spring/dubbo-consumer.properties")
    @ComponentScan(value = "top.xgoding.dubbo.samples.async.action")
    public static class ConsumerConfig{

    }
}
