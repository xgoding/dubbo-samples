package top.xgoding.dubbo.samples.echo.api.server;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import top.xgoding.dubbo.samples.echo.api.EchoService;
import top.xgoding.dubbo.samples.echo.api.server.impl.EchoServiceImpl;

import java.io.IOException;

/**
 * <p>
 *  API server 启动类
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.echo.api.server
 * @description:
 * @author: yxguang
 * @date: 2020/11/18
 * @version: V1.0
 * @modified: yxguang
 */
public class ApiServer {
    public static void main(String[] args) throws IOException {
        ServiceConfig<EchoService> service = new ServiceConfig<>();
        //1.配置服务名称
        service.setApplication(new ApplicationConfig("dubbo-samples-echo-api-server"));
        //2.配置注册中心
        service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        //3.配置协议端口
        service.setProtocol(new ProtocolConfig("dubbo",20880));
        //4.指定服务暴露的接口
        service.setInterface(EchoService.class);
        //5.指定真实服务对象
        service.setRef(new EchoServiceImpl());
        //6.暴露服务
        service.export();
        System.out.println("Dubbo API server start.");
        System.in.read();

    }
}
