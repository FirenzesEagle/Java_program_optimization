package cn.edu.bupt.ch1.DynamicProxy_Pattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用CGLIB的动态代理
 *
 * Created by FirenzesEagle on 2016/5/13 0013.
 * Email:liumingbo2008@gmail.com
 */
public class CglibDbQueryInterceptor implements MethodInterceptor {

    IDBQuery real = null;

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (real == null){
            real = new DBQuery();
        }
        return real.request();
    }

    public static IDBQuery createCglibProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibDbQueryInterceptor());    //指定拦截器，定义代理类逻辑
        enhancer.setInterfaces(new Class[] {IDBQuery.class});   //指定实现的接口
        IDBQuery cglibProxy = (IDBQuery) enhancer.create(); //生成代理类的实例
        return cglibProxy;
    }

}
