package top.xgoding.dubbo.samples.annotation.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * @date: 2020/11/23
 * @version: V1.0
 * @modified: yxguang
 */
@DubboService(protocol = {"dubbo"},version = "1.0.0",group = "en")
public class GreetingServiceEnImpl implements GreetingService {
    @Override
    public String sayHello(String name) {
        return "group [en] [1.0.0] hello, " + name;
    }
}
