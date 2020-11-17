package top.xgoding.dubbo.samples.echo.annotation.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.xgoding.dubbo.samples.echo.annotation.client.action.EchoAction;
import top.xgoding.dubbo.samples.echo.annotation.client.config.ConsumerConfiguration;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.annotation.client
 * @description:
 * @author: yxguang
 * @date: 2020/11/17
 * @version: V1.0
 * @modified: yxguang
 */
public class AnnotationConsumer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        EchoAction action = context.getBean(EchoAction.class);
        String echo = action.echo("Hello World!");
        System.out.println("Echo from Annotation server: " + echo);
    }
}
