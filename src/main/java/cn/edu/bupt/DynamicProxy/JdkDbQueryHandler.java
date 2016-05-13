package cn.edu.bupt.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用JDK的动态代理
 *
 * Created by FirenzesEagle on 2016/5/13 0013.
 * Email:liumingbo2008@gmail.com
 */
public class JdkDbQueryHandler implements InvocationHandler {

    IDBQuery idbQuery = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (idbQuery == null) {
            idbQuery = new DBQuery();
        }
        return idbQuery.request();
    }

    public static IDBQuery createJdkProxy() {
        IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IDBQuery.class}, new JdkDbQueryHandler());  //指定Handler
        return jdkProxy;
    }

}
