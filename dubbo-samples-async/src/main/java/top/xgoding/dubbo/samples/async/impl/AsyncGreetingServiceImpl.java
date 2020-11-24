package top.xgoding.dubbo.samples.async.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.AsyncContext;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.xgoding.dubbo.samples.async.api.AsyncGreetingService;

import java.util.Calendar;
import java.util.concurrent.CompletableFuture;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.async.impl
 * @description:
 * @author: yxguang
 * @date: 2020/11/23
 * @version: V1.0
 * @modified: yxguang
 */
@DubboService
public class AsyncGreetingServiceImpl implements AsyncGreetingService {
    private static final Logger logger = LoggerFactory.getLogger(AsyncGreetingServiceImpl.class);
    //定义 CompletableFuture 签名的接口实现
    @Override
    public CompletableFuture<String> sayHello(String name) {
        //Provider 端异步执行
        //RpcContext savedContext = RpcContext.getContext();
        logger.info("Async Provider dubbo thread:[{}]",Thread.currentThread().getName());
        // 建议为supplyAsync提供自定义线程池，避免使用JDK公用线程池
        return CompletableFuture.supplyAsync(() -> {
            logger.info("Async Provider work thread:[{}]",Thread.currentThread().getName());
            //System.out.println(savedContext.getAttachment("consumer-key1"));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello "+name+", async response from provider.";
        });
    }

    //使用AsyncContext 实现
    @Override
    public String goodbye(String name) {
        AsyncContext asyncContext = RpcContext.startAsync();
        new Thread(()->{
            // 如果要使用上下文，则必须要放在第一句执行
            asyncContext.signalContextSwitch();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 写回响应
            asyncContext.write("goodbye " + name + ", async response from provider.");
        }).start();
        return null;
    }
}
