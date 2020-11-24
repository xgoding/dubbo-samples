package top.xgoding.dubbo.samples.annotation.action;

import org.apache.dubbo.config.annotation.DubboReference;
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
    @DubboReference
    GreetingService greetingService;

    @DubboReference(group = "en",version = "1.0.0")
    GreetingService greetingServiceEnV1;
    @DubboReference(group = "en",version = "2.0.0")
    GreetingService greetingServiceEnV2;

    @DubboReference(group = "zh", version = "1.0.0")
    GreetingService greetingServiceZh;

    @DubboReference(group = "gd", version = "1.0.0")
    GreetingService greetingServiceGd;

    public void sayHello(String name) {
        System.out.println(greetingService.sayHello(name));
    }

    public void sayHelloV1(String name) {
        String hello = greetingServiceEnV1.sayHello(name);
        System.out.println(hello);
    }

    public void sayHelloV2(String name) {
        String hello = greetingServiceEnV2.sayHello(name);
        System.out.println(hello);
    }

    public void sayHelloGd(String name) {
        String hello = greetingServiceGd.sayHello(name);
        System.out.println(hello);
    }

    public void sayHelloZh(String name) {
        String hello = greetingServiceZh.sayHello(name);
        System.out.println(hello);
    }

}
