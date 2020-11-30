package top.xgoding.dubbo.samples.callback.impl;

import org.apache.dubbo.config.annotation.DubboService;
import top.xgoding.dubbo.samples.callback.api.CallbackListener;
import top.xgoding.dubbo.samples.callback.api.CallbackService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.callback.impl
 * @description:
 * @author: yxguang
 * @date: 2020/11/30
 * @version: V1.0
 * @modified: yxguang
 */
@DubboService
public class CallbackServiceImpl implements CallbackService {
    private final Map<String, CallbackListener> listeners = new ConcurrentHashMap<>();

    public CallbackServiceImpl() {
        Thread t = new Thread(()->{
            while (true) {
                try {
                    for (Map.Entry<String, CallbackListener> entry : listeners.entrySet()) {
                        try {
                            entry.getValue().changed(getChanged(entry.getKey()));
                        } catch (Exception e) {
                            listeners.remove(entry.getKey());
                        }
                    }
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void addListener(String key, CallbackListener listener) {
        listeners.put(key, listener);
        listener.changed(getChanged(key)); // send notification for change
    }

    private String getChanged(String key) {
        return "Changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
