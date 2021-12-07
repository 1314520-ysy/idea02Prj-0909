package edu.soft2.entity;

/**
 * 单例模式，懒汉模式
 */
public class Singleton2 {
    private static Singleton2 INSTANCE = null;

    public static Singleton2 getInstance() {
       if(INSTANCE == null){
           INSTANCE = new Singleton2();
       }
        return INSTANCE;
    }
}
