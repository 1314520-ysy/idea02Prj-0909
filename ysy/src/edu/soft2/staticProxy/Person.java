package edu.soft2.staticProxy;
/**被代理*/
public class Person implements Consume{
    private String name;
    public String getName() { return  name;}
    public void setName(String name) {this.name = name;}

    @Override
    public void buy() {
        System.out.println(name+"支付货款，购买商品");
    }

    @Override
    public void add() {
        System.out.println("添加操作");
    }
}
