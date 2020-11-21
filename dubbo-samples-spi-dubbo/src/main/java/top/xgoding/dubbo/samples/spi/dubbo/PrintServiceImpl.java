package top.xgoding.dubbo.samples.spi.dubbo;

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
//SPI 具体实现
public class PrintServiceImpl implements PrintService {

    @Override
    public String printService(String message) {
        System.out.println("Printer print message: " + message);
        return "Printer print message : " + message ;
    }
}
