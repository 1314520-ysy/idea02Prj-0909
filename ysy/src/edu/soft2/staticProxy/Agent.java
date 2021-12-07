package edu.soft2.staticProxy;
/**代理类*/
public class Agent implements Consume{
    public String name;
    public String getName() {return  name;}
    public void setName(String name){this.name = name;}
    private Person person;
    public Agent(Person person){this.person = person;}

    @Override
    public void buy() {
        System.out.println(name+"提供货源，供"+person.getName()+"选择......");
        person.buy();
        System.out.println(name+"收到货款，发货给"+person.getName());
    }

    @Override
    public void add() {
        System.out.println("b e f o r e");
        person.add();
        System.out.println("a f t e r");
    }


}
