package top.xgoding.dubbo.samples.annotation.action;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import top.xgoding.dubbo.samples.annotation.api.GreetingService;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.annotation.action
 * @description:
 * @author: yxguang
 * @date: 2020/11/23
 * @version: V1.0
 * @modified: yxguang
 */
@Component
public class GreetingServiceConsumer {
    @Reference(group = "gd",version = "1.0.0")
    GreetingService greetingService;

    public String sayHello(String name) {
        return greetingService.sayHello(name);
    }
}
