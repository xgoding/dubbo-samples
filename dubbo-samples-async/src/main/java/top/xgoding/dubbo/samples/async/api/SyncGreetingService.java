package top.xgoding.dubbo.samples.async.api;

import org.apache.dubbo.config.annotation.Method;

import java.util.concurrent.CompletableFuture;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.async.api
 * @description:
 * @author: yxguang
 * @date: 2020/11/23
 * @version: V1.0
 * @modified: yxguang
 */
public interface SyncGreetingService {

    String sayHello(String name) throws InterruptedException;

    String goodbye(String name) throws InterruptedException;

    //goodbye 的异步实现，加上CompletableFuture 签名 使 goodbye 成为异步方法
    default CompletableFuture<String> goodbye(String name,String signal) throws InterruptedException {
        return CompletableFuture.completedFuture(goodbye(name));
    }
}
