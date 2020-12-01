package top.xgoding.dubbo.samples.context;

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
 * @package: top.xgoding.dubbo.samples.context
 * @description:
 * @author: yxguang
 * @date: 2020/12/1
 * @version: V1.0
 * @modified: yxguang
 */
public class Provider2Bootstrap {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfig.class);
        context.start();
        System.out.println("Callback provider2 start.");
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "top.xgoding.dubbo.samples.context.impl2")
    public static class ProviderConfig{

        @Bean
        ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("dubbo-context-provider-2");
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
            ProtocolConfig protocolConfig = new ProtocolConfig();
            protocolConfig.setPort(20882);
            protocolConfig.setName("dubbo");
            return protocolConfig;
        }
    }
}
