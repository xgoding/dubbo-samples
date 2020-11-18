package top.xgoding.dubbo.samples.echo.api.server.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import top.xgoding.dubbo.samples.echo.api.EchoService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.echo.api.server.impl
 * @description:
 * @author: yxguang
 * @date: 2020/11/18
 * @version: V1.0
 * @modified: yxguang
 */
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String message) {
        String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("[" + now + "] Hello " + message + ", request from consumer: " + RpcContext.getContext().getRemoteAddressString());
        return message;
    }
}
