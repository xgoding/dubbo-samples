package top.xgoding.dubbo.samples.annotation.impl;

import com.alibaba.dubbo.config.annotation.Service;
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
@Service(/*protocol = {"dubbo"},*/ version = "1.0.0", group = "zh")
public class GreetingServiceZhImpl implements GreetingService {
    @Override
    public String sayHello(String name) {
        System.out.println("group [zh] [GreetingServiceZhImpl] greeting service received: " + name);
        return "group [zh] [GreetingServiceZhImpl] 您好, " + name;
    }
}
