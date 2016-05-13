package cn.edu.bupt.DynamicProxy;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

/**
 * 使用Javassist的动态代理
 * <p>
 * Created by FirenzesEagle on 2016/5/13 0013.
 * Email:liumingbo2008@gmail.com
 */
public class JavassistDynDbQueryHandler implements MethodHandler {

    IDBQuery idbQuery = null;

    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
        if (idbQuery == null) {
            idbQuery = new DBQuery();
        }
        return idbQuery.request();
    }

    /**
     * 使用代理工厂创建动态代理
     *
     * @return 动态代理类
     * @throws Exception
     */
    public static IDBQuery createJavasisistDynProxy() throws Exception {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(new Class[]{IDBQuery.class});    //指定接口
        Class proxyClass = proxyFactory.createClass();
        IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();
        ((ProxyObject) javassistProxy).setHandler(new JavassistDynDbQueryHandler());    //设置Handler处理器
        return javassistProxy;
    }

    /**
     * 使用动态代码创建，这种方式创建的动态代理可以非常灵活，甚至可以在运行时生成业务逻辑
     *
     * @return
     * @throws Exception
     */
    public static IDBQuery createJavassistBytecodeDynamicProxy() throws Exception {

        return null;
    }

}
