package top.xgoding.dubbo.samples.cache.ext;

import org.apache.dubbo.cache.Cache;
import org.apache.dubbo.cache.CacheFactory;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.apache.dubbo.common.constants.CommonConstants.METHOD_KEY;

/**
 * <p>
 *  自定义缓存扩展
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.cache.ext
 * @description:
 * @author: yxguang
 * @date: 2020/11/27
 * @version: V1.0
 * @modified: yxguang
 */
public class MyLruCacheFactory implements CacheFactory {
    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();

    @Override
    public Cache getCache(URL url, Invocation invocation) {
        //String serviceName = invocation.getServiceName();
        url = url.addParameter(METHOD_KEY, invocation.getMethodName());
        String key = url.toFullString();
        Cache cache = caches.get(key);
        System.out.println("Get cache : "+cache);
        if (cache == null) {
            caches.put(key, createCache());
            cache = caches.get(key);
        }
        return cache;
    }

    private Cache createCache() {
        return new MyCache();
    }

    public class MyCache implements Cache{
        private final ConcurrentHashMap<Object, Object> stores = new ConcurrentHashMap<>();

        @Override
        public void put(Object key, Object value) {
            stores.put(key, value);
        }

        @Override
        public Object get(Object key) {
            return stores.get(key);
        }
    }
}
