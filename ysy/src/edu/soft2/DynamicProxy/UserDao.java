package edu.soft2.DynamicProxy;

public class UserDao implements Dao{
    @Override
    public void add() {
        System.out.println("数据库的增操作");
    }

    @Override
    public void delete() {
        System.out.println("数据库的删操作");
    }

    @Override
    public void update() {
        System.out.println("数据库的改操作");
    }

    @Override
    public void query() {
        System.out.println("数据库的查操作");
    }
}
