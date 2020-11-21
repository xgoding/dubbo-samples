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
public class PrintServiceImpl2 implements PrintService{
    @Override
    public String printService(String message) {
        System.out.println("Printer2 print message: " + message);
        return "Printer2 print message : " + message ;
    }

    @Override
    public String adaptivePrint(String message) {
        System.out.println("Adaptive Printer print message: " + message);
        return "Adaptive Printer2 print message : " + message ;
    }
}
