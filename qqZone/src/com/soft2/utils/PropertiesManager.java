package com.soft2.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * database.properties属性文件的管理：读取文件内容，并提供getString()方法(通过名获取值)
 */
public class PropertiesManager {
    private static PropertiesManager propertiesManager;//声明静态变量
    private static Properties properties;//声明静态变量
    private PropertiesManager(){//当前类的构造方法
        String configFile="db.properties";//属性文件的路径
        properties=new Properties();
        //获取属性文件的输入流in
        InputStream in=
                PropertiesManager.class.getClassLoader().getResourceAsStream(configFile);
        try {
            properties.load(in);//读取输入流in中的属性文件的数据到properties对象中
            in.close();//关闭输入流in
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @return 当前类PropertiesManager的单例
     */
    public static PropertiesManager getInstance(){
        if(propertiesManager==null){
            propertiesManager=new PropertiesManager();
        }
        return propertiesManager;
    }

    /**
     * 获取读入properties中的属性文件的参数
     * @param key 属性文件的参数名
     * @return 属性文件的参数值
     */
    public String getString(String key){
        return properties.getProperty(key);
    }

}
