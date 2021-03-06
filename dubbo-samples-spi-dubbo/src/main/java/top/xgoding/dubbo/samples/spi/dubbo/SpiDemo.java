package top.xgoding.dubbo.samples.spi.dubbo;


import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.spi.dubbo
 * @description:
 * @author: yxguang
 * @date: 2020/11/21
 * @version: V1.0
 * @modified: yxguang
 */
public class SpiDemo {
    public static void main(String[] args) {
        //Dubbo SPI 调用
        //通过 ExtensionLoader 调用默认 SPI 实现
        PrintService defaultExtension = ExtensionLoader.getExtensionLoader(PrintService.class).getDefaultExtension();
        defaultExtension.printService("hello world");
        PrintService impl2 = ExtensionLoader.getExtensionLoader(PrintService.class).getExtension("impl2");
        impl2.printService("hello world");
    }
}
