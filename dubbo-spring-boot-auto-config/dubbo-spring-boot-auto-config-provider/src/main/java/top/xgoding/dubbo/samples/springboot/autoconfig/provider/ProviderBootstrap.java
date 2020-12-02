package top.xgoding.dubbo.samples.springboot.autoconfig.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.springboot.autoconfig.provider
 * @description:
 * @author: yxguang
 * @date: 2020/12/2
 * @version: V1.0
 * @modified: yxguang
 */
@EnableAutoConfiguration
public class ProviderBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ProviderBootstrap.class, args);
    }
}
