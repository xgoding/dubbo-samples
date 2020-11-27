package top.xgoding.dubbo.samples.attachement.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import top.xgoding.dubbo.samples.attachement.api.GreetingService;

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
    @Override
    public String sayHi(String name) {
        String hiddenName = RpcContext.getContext().getAttachment("name");
        return "Hi " + name + ", hiddenName: " + hiddenName;
    }
}
