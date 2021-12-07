package edu.soft2.test;

public class A {
    public static void main(String[] args) {
        B b = new B();//原型
        b.name = "许嘉威";
        b.age = 19;
        System.out.println(b);//原型对象打印
        B b1 = b.clone();
        System.out.println(b1);//克隆对象打印
        B b2 = b.clone();
        System.out.println(b2);//克隆对象打印
        System.out.println(new B());
    }
}
