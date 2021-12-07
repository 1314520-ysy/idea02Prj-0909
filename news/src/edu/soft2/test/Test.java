package edu.soft2.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.Class.forName;

public class Test {
    public static void main(String[] args) {
        //方式1.new关键字创建Foo对象，并调用hello()方法
//        Foo foo = new Foo();//执行Foo.java文件中构造方法，创建对象
//        foo.hello();//对象调用Foo.java文件中的hello()方法
        //方式2.(只有Foo.class文件，没有Foo.java文件)反射的方式创建Foo对象，并调用hello()方法
        try {
            Foo foo2 = (Foo)Class.forName("edu.soft2.test.Foo").newInstance();
//            Object foo2 = edu.soft2.test.Foo.class.newInstance();
            Method method = foo2.getClass().getDeclaredMethod("hello",new Class<?>[0]);
            method.invoke(foo2);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
