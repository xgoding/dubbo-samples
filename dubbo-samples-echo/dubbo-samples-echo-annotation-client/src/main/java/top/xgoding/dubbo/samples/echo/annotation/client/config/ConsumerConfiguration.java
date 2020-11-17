package top.xgoding.dubbo.samples.echo.annotation.client.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.annotation.client.config
 * @description:
 * @author: yxguang
 * @date: 2020/11/17
 * @version: V1.0
 * @modified: yxguang
 */
@Configuration
@EnableDubbo(scanBasePackages = "top.xgoding.dubbo.samples.echo")
@ComponentScan(basePackages = {"top.xgoding.dubbo.samples.echo"})
public class ConsumerConfiguration {

    @Bean
    public ConsumerConfig consumerConfig() {
        return new ConsumerConfig();
    }

    @Bean
    ApplicationConfig applicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("dubbo-samples-echo-annotation-client");
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
        config.setName("dubbo");
        config.setPort(20880);
        return config;
    }

}
