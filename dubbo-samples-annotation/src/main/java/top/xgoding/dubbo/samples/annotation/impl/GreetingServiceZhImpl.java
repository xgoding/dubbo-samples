package top.xgoding.dubbo.samples.annotation.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Qualifier;
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
@DubboService(protocol = {"dubbo"}, version = "1.0.0", group = "zh")
public class GreetingServiceZhImpl implements GreetingService {
    @Override
    public String sayHello(String name) {
        return "group [zh] [1.0.0] 您好, " + name;
    }
}
