package top.xgoding.dubbo.samples.echo.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.xgoding.dubbo.samples.echo.annotation.config.ProviderConfiguration;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.echo.annotation
 * @description:
 * @author: yxguang
 * @date: 2020/11/17
 * @version: V1.0
 * @modified: yxguang
 */
public class AnnotationProvider {
    public static void main(String[] args) throws IOException {
        //1.加载容器配置
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        //2.启动容器
        context.start();
        System.out.println("Annotation echo server start.");
        System.in.read();
    }
}
