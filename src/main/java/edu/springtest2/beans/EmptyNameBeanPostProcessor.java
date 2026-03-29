package edu.springtest2.beans;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class EmptyNameBeanPostProcessor implements BeanPostProcessor {
    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Arrays.stream(bean.getClass()
                .getDeclaredFields())
                .filter(f -> f.getName().equals("name")&&f.getType()==String.class)
                .forEach(f -> {
                    f.setAccessible(true);
                    try {
                        if(f.get(bean)==null){
                            f.set(bean, "vasia");
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
        return bean;
    }
}
