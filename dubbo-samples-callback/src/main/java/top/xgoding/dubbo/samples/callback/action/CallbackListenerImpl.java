package top.xgoding.dubbo.samples.callback.action;

import top.xgoding.dubbo.samples.callback.api.CallbackListener;

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
public class CallbackListenerImpl implements CallbackListener {
    @Override
    public void changed(String msg) {
        System.out.println(" listener changed: " + msg);
    }
}
