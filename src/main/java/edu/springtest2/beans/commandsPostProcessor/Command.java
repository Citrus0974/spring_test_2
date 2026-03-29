package edu.springtest2.beans.commandsPostProcessor;

import java.lang.reflect.Method;

public interface Command {
    Object exec(Object proxy, Object target, Method method, Object[] args) throws Throwable;
}
