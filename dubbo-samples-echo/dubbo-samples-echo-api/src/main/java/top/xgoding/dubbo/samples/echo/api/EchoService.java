package top.xgoding.dubbo.samples.echo.api;

/**
 * <p>
 * 回声测试接口
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.echo.api
 * @description:
 * @author: yxguang
 * @date: 2020/11/17
 * @version: V1.0
 * @modified: yxguang
 */
public interface EchoService {
    String echo(String message);
}
