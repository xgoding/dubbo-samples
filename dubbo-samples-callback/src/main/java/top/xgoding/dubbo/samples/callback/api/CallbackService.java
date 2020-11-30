package top.xgoding.dubbo.samples.callback.api;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.callback
 * @description:
 * @author: yxguang
 * @date: 2020/11/30
 * @version: V1.0
 * @modified: yxguang
 */
public interface CallbackService {
    void addListener(String key, CallbackListener listener);
}
