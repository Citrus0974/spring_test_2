package edu.springtest2.beans.example;

import edu.springtest2.annotations.Cache;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
class CacheAnnotationBeanPostProcessor implements BeanPostProcessor {
    String objName;

    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class clz = bean.getClass();
        if (clz.isAnnotationPresent(Cache.class)) {
            objName = beanName;
        }
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class clz = bean.getClass();
        if (beanName.equals(objName)) {
            System.out.println("cache " + bean);
            return Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(),
                    new Handler(bean));
        }
        return bean;
    }
}
