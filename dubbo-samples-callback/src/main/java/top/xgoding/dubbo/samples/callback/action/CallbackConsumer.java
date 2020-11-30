package top.xgoding.dubbo.samples.callback.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;
import top.xgoding.dubbo.samples.callback.api.CallbackListener;
import top.xgoding.dubbo.samples.callback.api.CallbackService;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.callback.action
 * @description:
 * @author: yxguang
 * @date: 2020/11/30
 * @version: V1.0
 * @modified: yxguang
 */
@Component
public class CallbackConsumer {
    @DubboReference
    CallbackService callbackService;

    public void addListener() {
        callbackService.addListener("foo", new CallbackListenerImpl());
        callbackService.addListener("bar", new CallbackListenerImpl());
    }
}
