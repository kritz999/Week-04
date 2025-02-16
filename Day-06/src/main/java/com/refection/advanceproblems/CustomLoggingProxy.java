package com.refection.advanceproblems;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CustomLoggingProxy {
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // Logging before method execution
                        System.out.println("🔹 Invoking method: " + method.getName());

                        // Execute the actual method
                        return method.invoke(target, args);
                    }
                }
        );
    }
}