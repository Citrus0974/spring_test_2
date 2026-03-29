package edu.springtest2.beans.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class Handler implements InvocationHandler {
    Object obj;

    public Handler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}
