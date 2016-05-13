package cn.edu.bupt.Singleton;

/**
 * 缺点：没有实现延迟加载，JVM加载单例类时，单例对象就会被创建
 * Created by FirenzesEagle on 2016/5/11 0011.
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton(){
        System.out.println("Singleton is create");  //创建单例的过程可能会比较慢
    }

    public static Singleton getInstance(){
        return instance;
    }

    public static void createString(){
        System.out.println("createString in Singleton");    //这是模拟单例类扮演其他角色
    }

}
