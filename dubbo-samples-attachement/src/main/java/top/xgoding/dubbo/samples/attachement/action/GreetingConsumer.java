package top.xgoding.dubbo.samples.attachement.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;
import top.xgoding.dubbo.samples.attachement.api.GreetingService;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.attachement.action
 * @description:
 * @author: yxguang
 * @date: 2020/11/27
 * @version: V1.0
 * @modified: yxguang
 */
@Component
public class GreetingConsumer {
    @DubboReference
    GreetingService greetingService;

    public void sayHi(String name) {
        String hi = greetingService.sayHi(name);
        System.out.println("Response from provider : " + hi);
    }
}
