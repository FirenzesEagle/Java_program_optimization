package cn.edu.bupt.ch2.Pool;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by FirenzesEagle on 2016/5/21 0021.
 * Email:liumingbo2008@gmail.com
 */
public class ObjectPoolDemo {

    static PooledObjectFactory factory = new PooledObjectFactoryDemo();
    static ObjectPool pool = new GenericObjectPool(factory);

    public static AtomicInteger endCount = new AtomicInteger(0);

    public static class PoolThread extends Thread {
        public void run() {
            Object object = null;
            try{
                for (int i = 0; i < 100; i++) {
                    System.out.println("== " + i + " ==");
                    object = pool.borrowObject();   //从池中得到对象
                    System.out.println(object + " is get"); //模拟使用对象
                    pool.returnObject(object);  //使用完成后，将对象返回池中
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                endCount.getAndIncrement();
            }

        }
    }

}
