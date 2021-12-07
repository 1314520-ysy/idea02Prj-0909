package edu.soft2.DynamicProxy.jdk;

import edu.soft2.DynamicProxy.Dao;
import edu.soft2.DynamicProxy.UserDao;


public class Test {
//    public static void main(String[] args) {
//        Dao dao = (Dao) Proxy.newProxyInstance(
//                Dao.class.getClassLoader(),
//                new Class[]{Dao.class},
//                new AgentJdk(new UserDao()));
//        dao.add();
//        dao.delete();
//        dao.update();
//        dao.query();
//    }
public static void main(String[] args) {
    AgentCglib agent=new AgentCglib();
    Dao dao = (Dao) agent.getInstance(UserDao.class);
    dao.add();
    dao.delete();
    dao.update();
    dao.query();
}

}
