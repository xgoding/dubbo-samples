package top.xgoding.dubbo.samples.cache;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.CountDownLatch;

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
public class ProviderBootstrap {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfig.class);
        context.start();
        new CountDownLatch(1).await();
    }

    @EnableDubbo(scanBasePackages = "top.xgoding.dubbo.samples.cache.impl")
    public static class ProviderConfig{
        @Bean
        ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("dubbo-cache-provider");
            return applicationConfig;
        }

        @Bean
        RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress("zookeeper://127.0.0.1:2181");
            return registryConfig;
        }

        @Bean
        ProtocolConfig protocolConfig() {
            ProtocolConfig config = new ProtocolConfig();
            config.setName("dubbo");
            config.setPort(20880);
            return config;
        }
    }
}
