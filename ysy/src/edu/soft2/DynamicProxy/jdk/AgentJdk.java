package edu.soft2.DynamicProxy.jdk;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AgentJdk implements InvocationHandler {
    private Object obj;
    public  AgentJdk(final Object obj){
        super();
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk代理.权限校验...");
        Object result = method.invoke(obj,args);
        System.out.println("jdk代理.日志记录...");
        return result;
    }
}
