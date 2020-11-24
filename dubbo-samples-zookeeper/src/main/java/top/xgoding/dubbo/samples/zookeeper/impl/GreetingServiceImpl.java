package top.xgoding.dubbo.samples.zookeeper.impl;

import org.apache.dubbo.config.annotation.DubboService;
import top.xgoding.dubbo.samples.zookeeper.api.GreetingService;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.zookeeper.impl
 * @description:
 * @author: yxguang
 * @date: 2020/11/19
 * @version: V1.0
 * @modified: yxguang
 */
@DubboService
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greeting(String message) {
        System.out.println("Provider Thread: " + Thread.currentThread().getName());
        return "Hello: " + message;
    }
}
