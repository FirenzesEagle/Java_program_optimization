package cn.edu.bupt.ch1.Pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 对象池工厂实现类
 * apache.commons.pool2完全重写了对象池的实现，显著的提升了性能和可伸缩性，特别是在高并发加载的情况下。
 * 2.0 版本包含可靠的实例跟踪和池监控，要求 JDK 1.6 或者更新版本。
 * <p>
 * Created by FirenzesEagle on 2016/5/21 0021.
 * Email:liumingbo2008@gmail.com
 */
public class PooledObjectFactoryDemo implements PooledObjectFactory {

    //在Java语言中，++i和i++操作并不是线程安全的，在使用的时候，不可避免的会用到synchronized关键字。而AtomicInteger则通过一种线程安全的加减操作接口。
    private static AtomicInteger counter = new AtomicInteger(0);

    /**
     * 定义如何创建一个新的对象实例
     *
     * @return
     * @throws Exception
     */
    @Override
    public PooledObject makeObject() throws Exception {
        Object object = String.valueOf(counter.getAndIncrement());
        System.out.println("Create Object " + object);
        return new DefaultPooledObject<>(object);
    }

    /**
     * 在对象从对象池中取出前，会激活这对象
     *
     * @param pooledObject
     * @throws Exception
     */
    @Override
    public void activateObject(PooledObject pooledObject) throws Exception {
        System.out.println("Before borrow " + pooledObject);
    }

    /**
     * 在对象返回对象池时被调用
     *
     * @param pooledObject
     * @throws Exception
     */
    @Override
    public void passivateObject(PooledObject pooledObject) throws Exception {
        System.out.println("Return " + pooledObject);
    }

    /**
     * 判断对象是否可用
     *
     * @param pooledObject
     * @return
     */
    @Override
    public boolean validateObject(PooledObject pooledObject) {
        return true;
    }

    /**
     * 对象从对象池中被销毁时，会执行这个方法
     *
     * @param pooledObject
     * @throws Exception
     */
    @Override
    public void destroyObject(PooledObject pooledObject) throws Exception {
        System.out.println("Destroying Object " + pooledObject);
    }

}
