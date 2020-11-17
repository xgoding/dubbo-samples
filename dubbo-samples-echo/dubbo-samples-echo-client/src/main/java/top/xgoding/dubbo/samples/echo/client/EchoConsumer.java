package top.xgoding.dubbo.samples.echo.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.xgoding.dubbo.samples.echo.api.EchoService;

/**
 * <p>
 *  回声测试消费者
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.echo.client
 * @description:
 * @author: yxguang
 * @date: 2020/11/17
 * @version: V1.0
 * @modified: yxguang
 */
public class EchoConsumer {
    public static void main(String[] args) {
        //1.加载配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/echo-consumer.xml"});
        //2.启动容器
        context.start();
        //3.加载接口引用，获取消息代理
        EchoService echoService = (EchoService) context.getBean("echoService");
        String echo = echoService.echo("Hello World!");
        System.out.println("echo result: " + echo);
    }
}
