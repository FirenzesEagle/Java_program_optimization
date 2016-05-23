package cn.edu.bupt.ch1.DynamicProxy_Pattern;

/**
 * Tips:相同代理类的重复生成会使用cache，故动态代理对象的方法调用性能应该作为性能的主要关注点
 *
 * Created by FirenzesEagle on 2016/5/13 0013.
 * Email:liumingbo2008@gmail.com
 */
public class Main {

    public static final int CIRCLE = 30000000;

    public static void main(String[] args) throws Exception {
        IDBQuery idbQuery = null;
        long begin = System.currentTimeMillis();
        /*
        * 测试JDK动态代理
        * */
        idbQuery = JdkDbQueryHandler.createJdkProxy();
        System.out.println("createJdkProxy: " + (System.currentTimeMillis() - begin));
        System.out.println("JdkProxy class: " + idbQuery.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            idbQuery.request();
        }
        System.out.println("callJdkProxy" + (System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();

        /*
        * 测试CGLIB动态代理
        * */
        idbQuery = CglibDbQueryInterceptor.createCglibProxy();
        System.out.println("createCglibProxy: " + (System.currentTimeMillis() - begin));
        System.out.println("CglibProxy class: " + idbQuery.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            idbQuery.request();
        }
        System.out.println("callCglibProxy" + (System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();

        /*
        * 测试JavasisistDynProxy动态代理
        * */
        idbQuery = JavassistDynDbQueryHandler.createJavasisistDynProxy();
        System.out.println("createJavasisistDynProxy: " + (System.currentTimeMillis() - begin));
        System.out.println("JavasisistDynProxy class: " + idbQuery.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            idbQuery.request();
        }
        System.out.println("callJavasisistDynProxy" + (System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();

        /*
        * 测试JavassistBytecodeDynamicProxy动态代理
        * */
        idbQuery = JavassistDynDbQueryHandler.createJavassistBytecodeDynamicProxy();
        System.out.println("createJavassistBytecodeDynamicProxy: " + (System.currentTimeMillis() - begin));
        System.out.println("JavassistBytecodeDynamicProxy class: " + idbQuery.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            idbQuery.request();
        }
        System.out.println("callJavassistBytecodeDynamicProxy" + (System.currentTimeMillis() - begin));

    }

}
