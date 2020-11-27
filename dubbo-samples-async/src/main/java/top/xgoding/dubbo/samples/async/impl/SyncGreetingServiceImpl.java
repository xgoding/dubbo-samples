package top.xgoding.dubbo.samples.async.impl;

import org.apache.dubbo.config.annotation.DubboService;
import top.xgoding.dubbo.samples.async.api.SyncGreetingService;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.async.impl
 * @description:
 * @author: yxguang
 * @date: 2020/11/23
 * @version: V1.0
 * @modified: yxguang
 */
@DubboService
public class SyncGreetingServiceImpl implements SyncGreetingService {
    @Override
    public String sayHello(String name) throws InterruptedException {
        Thread.sleep(1000);
        return "Sync Hello " + name;
    }

    @Override
    public String goodbye(String name) throws InterruptedException {
        Thread.sleep(1000);
        return "Sync Goodbye "+name;
    }
}
