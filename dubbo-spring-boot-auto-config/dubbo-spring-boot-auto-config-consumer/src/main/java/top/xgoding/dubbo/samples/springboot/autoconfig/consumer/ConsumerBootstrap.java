package top.xgoding.dubbo.samples.springboot.autoconfig.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import top.xgoding.dubbo.samples.echo.api.EchoService;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.springboot.autoconfig.consumer
 * @description:
 * @author: yxguang
 * @date: 2020/12/2
 * @version: V1.0
 * @modified: yxguang
 */
@EnableAutoConfiguration
public class ConsumerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerBootstrap.class, args);
    }

    @DubboReference(
            version = "1.0",
            timeout = 300
    )
    private EchoService echoService;

    @Bean
    public ApplicationRunner runner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments applicationArguments) throws Exception {
                Object xgoding = echoService.echo("xgoding");
                System.out.println(xgoding);
            }
        };
    }
}
