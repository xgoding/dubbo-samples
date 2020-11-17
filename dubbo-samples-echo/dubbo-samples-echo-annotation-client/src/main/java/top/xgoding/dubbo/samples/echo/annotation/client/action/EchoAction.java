package top.xgoding.dubbo.samples.echo.annotation.client.action;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import top.xgoding.dubbo.samples.echo.api.EchoService;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.echo.annotation.client.action
 * @description:
 * @author: yxguang
 * @date: 2020/11/17
 * @version: V1.0
 * @modified: yxguang
 */
@Component
public class EchoAction {
    @Reference
    EchoService echoService;

    public String echo(String message) {
        return echoService.echo(message);
    }
}
