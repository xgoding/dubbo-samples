package top.xgoding.dubbo.samples.zookeeper.action;

import com.alibaba.dubbo.config.annotation.Reference;
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
    @Reference
    GreetingService greetingService;

    public String greeting(String message) {
        return greetingService.greeting(message);
    }
}
