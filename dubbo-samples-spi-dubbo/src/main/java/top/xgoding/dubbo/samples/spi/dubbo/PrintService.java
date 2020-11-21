package top.xgoding.dubbo.samples.spi.dubbo;

import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

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
//添加 dubbo spi 支持，默认实现为 impl
@SPI("impl")
public interface PrintService {
    String printService(String message);

    @Adaptive({"type"})
    String adaptivePrint(String message);
}
