package edu.soft2.DynamicProxy.jdk;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;

public class AgentCglib implements MethodInterceptor {
    Object getInstance(Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        Object obj = enhancer.create();
        return obj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理。权限校验....");
        Object resilt=methodProxy.invokeSuper(o,objects);
        System.out.println("cglib代理。日志记录....");
        return resilt;
    }

}
