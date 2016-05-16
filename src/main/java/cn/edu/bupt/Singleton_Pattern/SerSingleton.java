package cn.edu.bupt.Singleton_Pattern;

/**
 * 优点：序列化后即使重新反序列化也是生成的同一个实例
 * Created by FirenzesEagle on 2016/5/11 0011.
 */
public class SerSingleton implements java.io.Serializable {

    private static SerSingleton instance = new SerSingleton();
    String name;

    private SerSingleton(){
        System.out.println("Singleton_Pattern is create");  //创建单例的过程可能会比较慢
        name = "SerSingleton";
    }

    public static SerSingleton getInstance(){
        return instance;
    }

    public static void createString(){
        System.out.println("createString in Singleton_Pattern");
    }

    //此方法实现了私有的readResolve()方法，readObject方法已经形同虚设，它直接使用readResolve()替换了原本的返回值，从而在形式上实现了单例
    private Object readResolve(){
        return instance;
    }

}
