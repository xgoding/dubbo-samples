package top.xgoding.dubbo.samples.async.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import top.xgoding.dubbo.samples.async.api.AsyncGreetingService;
import top.xgoding.dubbo.samples.async.api.SyncGreetingService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.async.action
 * @description:
 * @author: yxguang
 * @date: 2020/11/23
 * @version: V1.0
 * @modified: yxguang
 */
@Component
public class GreetingConsumer {
    private static final Logger logger = LoggerFactory.getLogger(GreetingConsumer.class);
    @DubboReference
    AsyncGreetingService asyncGreetingService;
    @DubboReference(methods = {
            @Method(name = "sayHello", async = true),
            @Method(name = "goodbye", async = true, sent = true, isReturn = true)
    })
    SyncGreetingService syncGreetingService;

    //同步调用，异步执行
    public void syncCallAsyncSayHello(String name) throws ExecutionException, InterruptedException {
        logger.info("consumer sync call start.");
        CompletableFuture<String> future = asyncGreetingService.sayHello(name);
        logger.info("consumer sync call end.");
        String res = future.get();
        logger.info("consumer sync call res: [{}]", res);
    }

    //同步调用，异步执行2
    public void syncCallAsyncSayHello(String name, Consumer<String> consumer) {
        logger.info("consumer Async call start.");
        CompletableFuture<String> future = asyncGreetingService.sayHello(name);
        //增加异步回调
        future.whenComplete((v, t) -> {
            if (t != null) {
                //发生异常
                t.printStackTrace();
            } else {
                consumer.accept(v);
                logger.info("consumer Async call response [{}].", v);
            }
        });
        logger.info("consumer Async call end.");
    }

    //同步调用，异步执行3
    public void syncCallAsyncGoodBye(String name) {
        System.out.println("Sync call Async goodbye start");
        String goodbye = asyncGreetingService.goodbye(name);
        System.out.println("Sync call Async goodbye end " + goodbye);
    }

    //同步调用，同步执行
    public void syncCallSyncSayHello() throws InterruptedException {
        System.out.println("Sync call Sync goodbye start.");
        System.out.println(syncGreetingService.goodbye("xgoding"));
        System.out.println("Sync call Sync goodbye end.");
    }

    //Dubbo 异步调用方式
    //1.需要 Provider实现 CompletableFuture 签名的服务，参考服务端异步执行

    //2.使用 RpcContext , 标注方法为异步
    //异步调用，同步执行
    public void asyncCallSyncSayHello() throws InterruptedException {
        //立刻返回空
        String xgoding = syncGreetingService.sayHello("xgoding");
        System.out.println("consumer Async call Sync sayHello rapidly response : " + xgoding);
        // 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
        CompletableFuture<String> helloFuture = RpcContext.getContext().getCompletableFuture();
        // 为Future添加回调
        helloFuture.whenComplete((retValue, exception) -> {
            if (exception == null) {
                System.out.println("consumer Async call Sync sayHello notify response : " + retValue);
            } else {
                exception.printStackTrace();
            }
        });
        System.out.println("consumer Async call Sync sayHello over ");
    }

    //2. RpcContext asyncCall 方式
    public void asyncCallSyncSayHello2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = RpcContext.getContext().asyncCall(
                () -> {
                    try {
                        return syncGreetingService.sayHello("xgoding");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return "error";
                    }
                }
        );
        System.out.println("consumer Async call Sync sayHello2 start");
        //阻塞调用
        String res = future.get();
        System.out.println("consumer Async call Sync sayHello2 end: " + res);
    }

    //3. 利用Java8 interface default 实现，重载一个带ComputableFuture签名方法
    // 标注调用方法为异步、send、return 等标识。

    /**
     * @see SyncGreetingService#goodbye(String, String)
     */
    public void asyncCallSyncGoodbye() throws InterruptedException {
        //加上标注后方法变为异步
        System.out.println("同步调用 同步执行 goodbye start");
        String xgoding = syncGreetingService.goodbye("xgoding");
        System.out.println("同步调用 同步执行 goodbye end : " + xgoding);
        System.out.println("同步调用 异步执行 goodbye start");
        CompletableFuture<String> goodbye = syncGreetingService.goodbye("xgoding", "asyncSignal");
        goodbye.whenComplete((v, t) -> {
            System.out.println("异步调用 异步执行 goodbye response : " + v);
        });
        System.out.println("同步调用 异步执行 goodbye end");
    }

}
