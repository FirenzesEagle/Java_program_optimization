package cn.edu.bupt.ch3.String_Append;

import org.junit.Test;

/**
 * 短字符串连接，用不同方法做多次常量连接，测试效率
 * <p>
 * Created by FirenzesEagle on 2016/5/23 0023.
 * Email:liumingbo2008@gmail.com
 */
public class TestAppendString {

    private static final int CIRCLE = 50000;

    /**
     * 对于静态字符串的连接操作，Java在编译时会进行彻底的优化，将多个连接操作的字符串在编译时合成一个单独的长字符串
     */
    @Test
    public void testStringAppend() {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            String result = "String" + "and" + "String" + "append";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testStringAppend 花费 ：" + (endTime - beginTime) + " ms");
    }

    @Test
    public void testStringAppend2_i() {
        long beginTime = System.currentTimeMillis();
        String str1 = "String";
        String str2 = "and";
        String str3 = "String";
        String str4 = "append";
        for (int i = 0; i < 50000; i++) {
            String result = str1 + str2 + str3 + str4;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testStringAppend2_i 花费 ：" + (endTime - beginTime) + " ms");
    }

}
