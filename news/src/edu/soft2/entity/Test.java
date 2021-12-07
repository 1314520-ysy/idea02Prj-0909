package edu.soft2.entity;

import java.util.ArrayList;
import java.util.List;

public class Test {
    /*public static void main(String[] args) {
        for (int i = 0;i < 5;i++){
            System.out.println("饿汉"+(i+1)+
                    Singleton1.getInstance());
        }
        for (int i = 0;i < 5;i++){
            System.out.println("懒汉"+(i+1)+
                    Singleton2.getInstance());
        }
    }*/
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("今天");
        list.add("是");
        list.add("2021年");
        list.add("10月13号");
        for (String a:
             list) {
            System.out.println(a);
        }
    }
}
