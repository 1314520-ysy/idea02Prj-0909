package edu.soft2.designFactory;

public class FactoryB implements Factory{
    @Override
    public Product manufacture() {
        System.out.println("B工厂生产");
        return new ProductY();
    }
}
