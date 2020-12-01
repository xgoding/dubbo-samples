package top.xgoding.dubbo.samples.context.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;
import top.xgoding.dubbo.samples.context.api.ContextService;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.context.action
 * @description:
 * @author: yxguang
 * @date: 2020/12/1
 * @version: V1.0
 * @modified: yxguang
 */
@Component
public class ContextConsumer {
    //客户端负载均衡: random 默认策略
    //@DubboReference(loadbalance = "random")
    //客户端负载均衡：roundrobin  轮询
    //@DubboReference(loadbalance = "roundrobin")
    //客户端负载均衡：LeastActive 最少活跃调用
    //@DubboReference(loadbalance = "leastactive")
    //客户端负载均衡：ConsistentHash 一致hash
    @DubboReference(loadbalance = "consistenthash")
    ContextService contextService;

    public void sayHi() {
        String xgoding = contextService.sayHi("xgoding");
        System.out.println(xgoding);
    }
}
