package top.xgoding.dubbo.samples.callback.api;

import java.io.Serializable;

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
public interface CallbackListener extends Serializable {
    void changed(String msg);
}
