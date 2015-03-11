package com.javarush.test.level32.lesson08.home01;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {

    private SomeInterfaceWithMethods original;

    public CustomInvocationHandler(SomeInterfaceWithMethods original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object result = method.invoke(original, args);
        System.out.println(method.getName() + " out");
        return result;
    }
}
