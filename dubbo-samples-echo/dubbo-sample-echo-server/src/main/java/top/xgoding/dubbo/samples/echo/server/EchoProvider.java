package top.xgoding.dubbo.samples.echo.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * <p>
 *  服务启动类
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.echo.server
 * @description:
 * @author: yxguang
 * @date: 2020/11/17
 * @version: V1.0
 * @modified: yxguang
 */
public class EchoProvider {
    public static void main(String[] args) throws IOException {
        //1.加载Spring上下文配置
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                //指定配置文件位置
                new String[]{"spring/echo-provider.xml"});
        //2.启动容器
        context.start();
        System.out.println("Echo Server Start.");
        System.in.read();
    }
}
