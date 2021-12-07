package edu.soft2.staticProxy;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("peter");
        Agent agent = new Agent(person);
        agent.setName("代理商B");
        agent.buy();
        agent.add();
    }

}
