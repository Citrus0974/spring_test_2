package edu.springtest2.beans.commandsPostProcessor;

import java.lang.reflect.Method;

public class LogCommand implements Command{

    @Override
    public Object exec(Object proxy, Object target, Method method, Object[] args) throws Throwable {
        System.out.println("Before: " + method.getName());

        Object result = method.invoke(target, args);

        System.out.println("After: " + method.getName());

        return result;
    }
}
