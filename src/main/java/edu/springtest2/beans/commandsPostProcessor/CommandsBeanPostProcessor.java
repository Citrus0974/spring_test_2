package edu.springtest2.beans.commandsPostProcessor;

import edu.springtest2.annotations.Log;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.util.*;

public class CommandsBeanPostProcessor implements BeanPostProcessor {
    private final Map<String, Map<Method, List<Command>>> commands = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Map<Method, List<Command>> methodCommands = new HashMap<>();

        for (Method method : bean.getClass().getDeclaredMethods()) {

            List<Command> list = new ArrayList<>();

            if (method.isAnnotationPresent(Log.class)) {
                list.add(new LogCommand());
            }

            if (!list.isEmpty()) {
                methodCommands.put(method, list);
            }
        }

        if (!methodCommands.isEmpty()) {
            commands.put(beanName, methodCommands);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (!commands.containsKey(beanName)) {
            return bean;
        }

        Map<Method, List<Command>> methodCommands = commands.get(beanName);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(bean.getClass());

        Object proxy = enhancer.create();

        enhancer.setCallback((InvocationHandler) (proxyObj, method, args) -> {

            Method originalMethod = findMethod(method, methodCommands);

            // если метод не обрабатывается — просто вызываем оригинал
            if (originalMethod == null) {
                return method.invoke(bean, args);
            }

            List<Command> cmds = methodCommands.get(originalMethod);

            Object result = null;

            for (Command cmd : cmds) {
                result = cmd.exec(proxyObj, bean, originalMethod, args);
            }

            return result;
        });

        return proxy;
    }

    private Method findMethod(Method proxyMethod, Map<Method, List<Command>> map) {
        for (Method m : map.keySet()) {
            if (m.getName().equals(proxyMethod.getName()) &&
                    Arrays.equals(m.getParameterTypes(), proxyMethod.getParameterTypes())) {
                return m;
            }
        }
        return null;
    }
}
