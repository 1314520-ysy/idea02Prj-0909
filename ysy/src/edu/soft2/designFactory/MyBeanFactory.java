package edu.soft2.designFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读出iocBean.properties文件中的内容.内容中的"名值对",根据"名"获取"值"
 */
public class MyBeanFactory {
    //定义一个Properties对象
    private static Properties properties = new Properties();
    //读取iocBean.properties配置文件
    static {//静态块
        InputStream in =
        MyBeanFactory.class.getClassLoader().getResourceAsStream("iocBean.properties");
        try {
            properties.load(in);//将配置文件输入流，加载到properties对象中
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //,根据"名"获取"值"
    public static Object getBean(String name){
        String className = properties.getProperty(name);
        System.out.println("bean的类名="+className);
        try {
           return Class.forName(className).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("配置文件的类名，无法转为对象，返回null");
        return null;
    }
}
