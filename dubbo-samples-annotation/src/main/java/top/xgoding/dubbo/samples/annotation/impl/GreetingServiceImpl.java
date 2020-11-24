package top.xgoding.dubbo.samples.annotation.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
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
@DubboService
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
