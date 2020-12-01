package top.xgoding.dubbo.samples.context.impl2;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import top.xgoding.dubbo.samples.context.api.ContextService;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.context.impl
 * @description:
 * @author: yxguang
 * @date: 2020/12/1
 * @version: V1.0
 * @modified: yxguang
 */
@DubboService
public class ContextServiceImpl2 implements ContextService {
    @Override
    public String sayHi(String name) {
        RpcContext context = RpcContext.getContext();
        String remoteHost = context.getRemoteHost();
        System.out.println("remoteHost:" + remoteHost);
        String remoteApplicationName = context.getRemoteApplicationName();
        System.out.println("application:" + remoteApplicationName);
        String remoteAddressString = context.getRemoteAddressString();
        String localAddressString = context.getLocalAddressString();
        String application = context.getUrl().getParameter("application");
        return "Hello: " + name + ". Provider Info: " + localAddressString + " , "+application+
                ", Client Info: " + remoteHost + ", " + remoteApplicationName + ", " + remoteAddressString;
    }
}
