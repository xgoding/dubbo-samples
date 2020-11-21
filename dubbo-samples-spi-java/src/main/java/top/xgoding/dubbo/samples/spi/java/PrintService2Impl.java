package top.xgoding.dubbo.samples.spi.java;

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
//Java SPI 具体实现
public class PrintService2Impl implements PrintService {
    @Override
    public String print(String message) {
        System.out.println("Printer2 print message: " + message);
        return "Printer2 print message : " + message;
    }
}
