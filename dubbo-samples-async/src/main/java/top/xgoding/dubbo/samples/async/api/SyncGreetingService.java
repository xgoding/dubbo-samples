package top.xgoding.dubbo.samples.async.api;

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

    String sayHello(String name);

    String goodbye(String name);
}
