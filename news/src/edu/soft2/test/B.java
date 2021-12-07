package edu.soft2.test;

public class B implements Cloneable{
    String name;
    int age;



    @Override
    protected B clone() {
            B b = null;
        try {
            b = (B) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
