package top.xgoding.dubbo.samples.zookeeper.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;
import top.xgoding.dubbo.samples.zookeeper.api.GreetingService;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.zookeeper.action
 * @description:
 * @author: yxguang
 * @date: 2020/11/19
 * @version: V1.0
 * @modified: yxguang
 */
@Component("greetingConsumer")
public class GreetingConsumer {
    @DubboReference
    GreetingService greetingService;

    public String greeting(String message) {
        System.out.println("Consumer Thread: " + Thread.currentThread().getName());
        return greetingService.greeting(message);
    }
}
