package top.xgoding.dubbo.samples.async;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

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
public class ProviderBootstrap {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfig.class);
        context.start();
        System.out.println("Provider start.");
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "top.xgoding.dubbo.samples.async.impl")
    @PropertySource(value = "classpath:spring/dubbo-provider.properties")
    public static class ProviderConfig {

    }
}
