package edu.soft2.entity;
/**
 * 单例模式，饿汉模式
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
