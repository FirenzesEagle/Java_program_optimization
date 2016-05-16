package cn.edu.bupt.Singleton_Pattern;

/**
 * 优点：当StaticSingleton被加载时，其内部类不会被初始化，当getInstance()方法被调用时，才会加载SingletonHolder，从而初始化instance
 * Created by FirenzesEagle on 2016/5/11 0011.
 */
public class StaticSingleton {

    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }

    private StaticSingleton(){
        System.out.println("StaticSingleton is create");  //创建单例的过程可能会比较慢
    }

    private static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }

}
