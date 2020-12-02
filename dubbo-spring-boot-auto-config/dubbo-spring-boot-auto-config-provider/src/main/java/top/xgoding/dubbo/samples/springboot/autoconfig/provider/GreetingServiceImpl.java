package top.xgoding.dubbo.samples.springboot.autoconfig.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import top.xgoding.dubbo.samples.echo.api.EchoService;

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
@DubboService(version = "1.0")
public class GreetingServiceImpl implements EchoService {
    @Value("${dubbo.application.name}")
    private String applicationName;

    @Override
    public String echo(String message) {
        return "echo from application : " + applicationName;
    }
}
