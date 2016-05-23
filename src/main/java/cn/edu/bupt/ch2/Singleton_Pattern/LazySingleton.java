package cn.edu.bupt.ch2.Singleton_Pattern;

/**
 * 优点：实现了延迟加载
 * 缺点：因为引入了线程同步，大大增加了耗时
 * Created by FirenzesEagle on 2016/5/11 0011.
 */
public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton(){
        System.out.println("LazySingleton is create");  //创建单例的过程可能会比较慢
    }

    //方法必须是同步的，否则在多线程环境下，当线程1正在新建单例时，完成赋值操作前，线程2可能判断instance为null，故线程2也将启动新建单例的程序，而导致多个实例被创建
    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

}
