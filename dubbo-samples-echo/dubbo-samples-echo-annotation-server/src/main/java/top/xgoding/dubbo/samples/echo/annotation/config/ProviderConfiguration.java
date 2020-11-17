package top.xgoding.dubbo.samples.echo.annotation.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *    服务配置
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.echo.annotation.config
 * @description:
 * @author: yxguang
 * @date: 2020/11/17
 * @version: V1.0
 * @modified: yxguang
 */
@Configuration
//指定扫描服务所在的包
@EnableDubbo(scanBasePackages = "top.xgoding.dubbo.samples.echo")
public class ProviderConfiguration {
    @Bean
    public ProviderConfig providerConfig() {
        return new ProviderConfig();
    }

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        //应用名称
        config.setName("dubbo-samples-echo-server-annotation");
        return config;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig config = new RegistryConfig();
        config.setProtocol("zookeeper");
        config.setAddress("127.0.0.1");
        config.setPort(2181);
        return config;
    }

    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig config = new ProtocolConfig();
        config.setName("dubbo");
        config.setPort(20880);
        return config;
    }

}
