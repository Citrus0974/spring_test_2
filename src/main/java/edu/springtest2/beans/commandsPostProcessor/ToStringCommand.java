package edu.springtest2.beans.commandsPostProcessor;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

public class ToStringCommand implements Command{
    @Override
    public Object exec(Object proxy, Object target, Method method, Object[] args) throws Throwable {
        System.out.println("log");
        Object result = method.invoke(target, args);
        System.out.println("log");

        return result;
    }
}
