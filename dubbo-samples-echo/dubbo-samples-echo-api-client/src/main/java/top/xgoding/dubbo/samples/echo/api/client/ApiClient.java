package top.xgoding.dubbo.samples.echo.api.client;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import top.xgoding.dubbo.samples.echo.api.EchoService;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.api.client
 * @description:
 * @author: yxguang
 * @date: 2020/11/18
 * @version: V1.0
 * @modified: yxguang
 */
public class ApiClient {
    public static void main(String[] args) {
        ReferenceConfig<EchoService> referenceConfig = new ReferenceConfig<>();
        //1.设置应用名称
        referenceConfig.setApplication(new ApplicationConfig("dubbo-samples-api-consumer"));
        //2.设置注册中心
        referenceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        //3.指定消费接口
        referenceConfig.setInterface(EchoService.class);
        //4.实现动态代理
        EchoService echoService = referenceConfig.get();
        String echo = echoService.echo("Hello World!");
        System.out.println("Echo from API server: " + echo);
    }
}
