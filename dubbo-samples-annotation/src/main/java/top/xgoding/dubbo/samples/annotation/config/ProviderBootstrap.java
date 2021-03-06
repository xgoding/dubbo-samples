package top.xgoding.dubbo.samples.annotation.config;

import org.apache.dubbo.config.spring.ServiceBean;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.annotation
 * @description:
 * @author: yxguang
 * @date: 2020/11/22
 * @version: V1.0
 * @modified: yxguang
 */
public class ProviderBootstrap {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.out.println("ProviderBootstrap server start.");
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = {"top.xgoding.dubbo.samples.annotation.impl"})
    @ComponentScan(basePackages = "top.xgoding.dubbo.samples.annotation.bug")
    @PropertySource(value = "classpath:spring/dubbo-provider.properties")
    public static class ProviderConfiguration {

    }

}
