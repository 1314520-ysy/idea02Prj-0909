package edu.soft2.designFactory;

public class Test {
    public static void main(String[] args) {
       /* Factory a = new FactoryA();//工厂实例创建
        Product p = a.manufacture();//开工生产
        p.show();//生产出的产品*/

        Product product = (Product) MyBeanFactory.getBean("bean-Product");
        product.show();

    }
}
