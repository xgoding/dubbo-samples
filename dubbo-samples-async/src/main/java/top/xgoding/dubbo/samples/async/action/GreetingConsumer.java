package top.xgoding.dubbo.samples.async.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import top.xgoding.dubbo.samples.async.api.AsyncGreetingService;

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
    private static Logger logger = LoggerFactory.getLogger(GreetingConsumer.class);
    @DubboReference
    AsyncGreetingService asyncGreetingService;

    //同步调用，异步执行
    public void syncSayHello(String name) throws ExecutionException, InterruptedException {
        logger.info("consumer sync call start.");
        CompletableFuture<String> future = asyncGreetingService.sayHello(name);
        logger.info("consumer sync call end.");
        String res = future.get();
        logger.info("consumer sync call res: [{}]", res);
    }

    //异步调用，异步执行
    public void asyncSayHello(String name, Consumer<String> consumer){
        logger.info("consumer Async call start.");
        CompletableFuture<String> future = asyncGreetingService.sayHello(name);
        //增加异步回调
        future.whenComplete((v, t) -> {
            if (t != null) {
                //发生异常
                t.printStackTrace();
            }else{
                consumer.accept(v);
                logger.info("consumer Async call response [{}].",v);
            }
        });
        logger.info("consumer Async call end.");
    }

}
