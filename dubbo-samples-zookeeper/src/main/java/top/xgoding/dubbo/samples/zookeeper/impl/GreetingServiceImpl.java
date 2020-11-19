package top.xgoding.dubbo.samples.zookeeper.impl;

import com.alibaba.dubbo.config.annotation.Service;
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
@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greeting(String message) {
        return "Hello: " + message;
    }
}
