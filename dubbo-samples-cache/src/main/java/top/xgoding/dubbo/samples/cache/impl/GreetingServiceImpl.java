package top.xgoding.dubbo.samples.cache.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import top.xgoding.dubbo.samples.cache.api.GreetingService;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.attachement.impl
 * @description:
 * @author: yxguang
 * @date: 2020/11/27
 * @version: V1.0
 * @modified: yxguang
 */
@DubboService
public class GreetingServiceImpl implements GreetingService {
    private final AtomicInteger i = new AtomicInteger();
    @Override
    public String sayHi(String name) {
        return "Hi " + name + ", index: " + i.getAndIncrement();
    }

    @Override
    public String goodbye(String name) {
        return "Goodbye " + name + ", index:" + i.getAndIncrement();
    }
}
