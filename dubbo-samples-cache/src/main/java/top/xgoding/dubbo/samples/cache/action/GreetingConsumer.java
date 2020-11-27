package top.xgoding.dubbo.samples.cache.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.stereotype.Component;
import top.xgoding.dubbo.samples.cache.api.GreetingService;

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
    //lru 缓存最热数据
    @DubboReference(/*cache = "lru"*/
            methods = {
                    @Method(name = "sayHi", cache = "lru"),
                    @Method(name = "goodbye",cache = "mcache")
            }
    )
    GreetingService greetingService;

    public void sayHi(String name) {
        System.out.println("Response from provider : " + greetingService.sayHi(name));
    }

    public void goodbye(String name) {
        System.out.println("Response from provider : " + greetingService.goodbye(name));
    }
}
