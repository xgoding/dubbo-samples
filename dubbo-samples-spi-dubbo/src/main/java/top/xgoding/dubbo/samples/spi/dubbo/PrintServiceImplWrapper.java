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
public class PrintServiceImplWrapper implements PrintService{
    PrintService printService;

    public PrintServiceImplWrapper(PrintService printService) {
        this.printService = printService;
    }

    @Override
    public String printService(String message) {
        System.out.println("Wrapper printer do something.");
        return printService.printService(message);
    }

    @Override
    public String adaptivePrint(String message) {
        System.out.println("Wrapper printer do something.");
        return printService.adaptivePrint(message);
    }

}
