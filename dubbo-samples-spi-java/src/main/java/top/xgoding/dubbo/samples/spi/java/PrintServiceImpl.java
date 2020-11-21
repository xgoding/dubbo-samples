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
//JAVA SPI 接口实现
public class PrintServiceImpl implements PrintService {
    @Override
    public String print(String message) {
        System.out.println("Printer print message: " + message);
        return "Printer print message : " + message ;
    }
}
