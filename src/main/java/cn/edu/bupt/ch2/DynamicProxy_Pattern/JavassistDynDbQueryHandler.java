package cn.edu.bupt.ch2.DynamicProxy_Pattern;

import javassist.*;
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

    IDBQuery real = null;

    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }

    /**
     * 使用代理工厂创建动态代理
     *
     * @return 生成的动态类
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
     * @return  生成的动态类
     * @throws Exception
     */
    public static IDBQuery createJavassistBytecodeDynamicProxy() throws Exception {
        ClassPool mPool = new ClassPool(true);
        CtClass mCtc = mPool.makeClass(IDBQuery.class.getName() + "JavassistBytecodeProxy");    //定义类名
        mCtc.addInterface(mPool.get(IDBQuery.class.getName())); //需要实现的接口
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc)); //添加构造函数
        mCtc.addField(CtField.make("public " + IDBQuery.class.getName() + " real;", mCtc));  //添加类的字段信息，使用动态Java代码
        String dbQueryName = DBQuery.class.getName();
        //添加方法，这里使用动态Java代码指定内部逻辑
        mCtc.addMethod(CtNewMethod.make("public String request() { if(real == null)real=new " + dbQueryName + "();return real.request(); }", mCtc));
        Class pc = mCtc.toClass();  //基于以上信息，生成动态类
        IDBQuery bytecodeProxy = (IDBQuery) pc.newInstance();   //生成动态类的实例
        return bytecodeProxy;
    }

}
