package top.xgoding.dubbo.samples.spi.java;

import java.util.ServiceLoader;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.java.spi
 * @description:
 * @author: yxguang
 * @date: 2020/11/21
 * @version: V1.0
 * @modified: yxguang
 */
public class SpiDemo {
    public static void main(String[] args) {
        //调用SPI具体实现
        //一次性全部加载PrintService接口全部实现类
        ServiceLoader<PrintService> serviceServiceLoader = ServiceLoader.load(PrintService.class);
        for (PrintService printService : serviceServiceLoader) {
            //获取所有SPI实现
            printService.print("hello world!");
        }
    }
}
