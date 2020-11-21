package top.xgoding.dubbo.samples.spi.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

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
    }
}
