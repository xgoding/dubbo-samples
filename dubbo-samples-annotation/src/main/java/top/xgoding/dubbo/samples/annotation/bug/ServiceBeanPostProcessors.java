package top.xgoding.dubbo.samples.annotation.bug;

import org.apache.dubbo.config.spring.ServiceBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * <p>
 * dubbo 2.7.7 Duplicate Service Bean BUG.
 * Duplicate ServiceBean found
 * https://github.com/apache/dubbo-spring-boot-project/issues/685
 * https://github.com/apache/dubbo/issues/5923
 * https://github.com/apache/dubbo/issues/6283
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.annotation.bug
 * @description:
 * @author: yxguang
 * @date: 2020/11/24
 * @version: V1.0
 * @modified: yxguang
 */
@Component
public class ServiceBeanPostProcessors implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().getTypeName().equals(ServiceBean.class.getTypeName()) && beanName.contains("ServiceBean")) {
            ServiceBean serviceBean = (ServiceBean) bean;
            serviceBean.setId(beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
