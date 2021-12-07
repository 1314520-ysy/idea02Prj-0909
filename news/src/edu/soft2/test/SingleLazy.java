package edu.soft2.test;

public class SingleLazy {
    static SingleLazy instance;//原则1:静态化对象
    private SingleLazy(){
        System.out.println("实例化一个新的懒汉模式");
        }//原则2:私有化构造方法
    public static synchronized SingleLazy getInstance(){//原则3:返回实例对象的公共方法
        if (instance == null) {
        instance = new SingleLazy();
        }
        return instance;
    }

    public static void main(String[] args) {
        int i = 0;
        while (i<1000){
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
//                        Singleton singleton = new
                    }
                }
            }).start();
            i++;
        }
    }
}
