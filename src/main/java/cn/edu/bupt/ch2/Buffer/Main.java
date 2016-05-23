package cn.edu.bupt.ch2.Buffer;

import static cn.edu.bupt.ch2.Buffer.CglibHeavyMethodInterceptor.newCacheHeavyMethod;
import static cn.edu.bupt.ch2.Buffer.CglibHeavyMethodInterceptor.newHeavyMethod;

/**
 * 缓存测试类，疑问：使用缓存比不使用缓存耗费时间还长,与循环的数量级有关
 *
 * Created by FirenzesEagle on 2016/5/19 0019.
 * Email:liumingbo2008@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        HeavyMethodDemo heavyMethodDemo = newCacheHeavyMethod();    //使用缓存
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {  //使用缓存时，只需要计算一次
            heavyMethodDemo.heavyMethod(2147483646);
        }
        System.out.println("cache method spend:" + (System.currentTimeMillis() - begin));

        heavyMethodDemo = newHeavyMethod(); //不使用缓存
        begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {  //不使用缓存时，每次都要计算
            heavyMethodDemo.heavyMethod(2147483646);
        }
        System.out.println("no cache method spend:" + (System.currentTimeMillis() - begin));

    }

}
