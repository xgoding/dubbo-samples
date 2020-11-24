package top.xgoding.dubbo.samples.annotation.annotation;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

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
public class ProviderBootstrap {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "top.xgoding.dubbo.samples.annotation.impl")
    public static class ProviderConfiguration {
        @Bean
        ApplicationConfig applicationConfig() {
            ApplicationConfig config = new ApplicationConfig();
            config.setName("provider-annotation");
            return config;
        }

        @Bean
        RegistryConfig registryConfig() {
            RegistryConfig config = new RegistryConfig();
            config.setProtocol("zookeeper");
            config.setAddress("127.0.0.1");
            config.setPort(2181);
            return config;
        }

        @Bean
        ProtocolConfig protocolConfig() {
            ProtocolConfig config = new ProtocolConfig();
            config.setId("dubbo");
            config.setName("dubbo");
            config.setPort(20880);
            return config;
        }
    }
}
