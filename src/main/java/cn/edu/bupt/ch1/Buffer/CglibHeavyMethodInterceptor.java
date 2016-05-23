package cn.edu.bupt.ch1.Buffer;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * Created by FirenzesEagle on 2016/5/19 0019.
 * Email:liumingbo2008@gmail.com
 */
public class CglibHeavyMethodInterceptor implements MethodInterceptor {

    HeavyMethodDemo real = new HeavyMethodDemo();

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String v = (String) EHCacheUtil.get("cache1", (Serializable) objects[0]);   //检查缓存
        //缓存中未找到结果
        if (v == null) {
            v = real.heavyMethod((Integer) objects[0]);
            EHCacheUtil.put("cache1", (Integer) objects[0], v); //将计算结果保存在缓存中
        }
        return v;
    }

    /**
     * 生成带有缓存功能的类
     *
     * @return  动态代理生成的类
     */
    public static HeavyMethodDemo newCacheHeavyMethod() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HeavyMethodDemo.class);
        enhancer.setCallback(new CglibHeavyMethodInterceptor());    //指定拦截器，定义代理类逻辑
        HeavyMethodDemo cglibProxy = (HeavyMethodDemo) enhancer.create();
        return cglibProxy;
    }

    public static HeavyMethodDemo newHeavyMethod() {
        return new HeavyMethodDemo();
    }

}
