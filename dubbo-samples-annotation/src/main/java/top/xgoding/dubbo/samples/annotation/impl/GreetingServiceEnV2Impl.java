package top.xgoding.dubbo.samples.annotation.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
import top.xgoding.dubbo.samples.annotation.api.GreetingService;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.annotation.impl
 * @description:
 * @author: yxguang
 * @date: 2020/11/24
 * @version: V1.0
 * @modified: yxguang
 */
@DubboService(protocol = {"dubbo"},version = "2.0.0",group = "en")
@Component("GreetingServiceDefaultV2Impl")
public class GreetingServiceEnV2Impl implements GreetingService {
    @Override
    public String sayHello(String name) {
        return "group [en] [2.0.0] hello, " + name;
    }
}
