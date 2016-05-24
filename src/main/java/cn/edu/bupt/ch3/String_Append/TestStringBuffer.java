package cn.edu.bupt.ch3.String_Append;

import org.junit.Test;

/**
 * 长字符长连接 StringBuffer 和StringBuilder比较
 * 它们都实现了AbstractStringBuilder抽象类，拥有几乎相同的对外接口
 * 两者最大的不同在于StringBuffer对几乎所有的方法都做了同步，而StringBuild没有
 * <p>
 * Created by FirenzesEagle on 2016/5/24 0024.
 * Email:liumingbo2008@gmail.com
 */
public class TestStringBuffer {

    private static final int CIRCLE = 50000;

    /**
     * str = str + i; testStringPlus 花费:6192 ms
     * str+=i; testStringPlus 花费:6275 ms
     */
    @Test
    public void testStringPlus() {
        String str = "";
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < CIRCLE; i++) {
            //str = str + i;
            str += i;
        }
        long endTime = System.currentTimeMillis();

        System.out.println("testStringPlus 花费:" + (endTime - beginTime) + " ms");
    }

    /**
     * testStringConcat 花费 ：2203 ms
     */
    @Test
    public void testStringConcat() {
        String result = "";
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < CIRCLE; i++) {
            result = result.concat(String.valueOf(i));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testStringConcat 花费 ：" + (endTime - beginTime) + " ms");
    }

    /**
     * testStringBuffer 花费:10 ms
     */
    @Test
    public void testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < CIRCLE; i++) {
            sb.append(i);
        }
        sb.toString();
        long endTime = System.currentTimeMillis();
        System.out.println("testStringBuffer 花费:" + (endTime - beginTime) + " ms");
    }

    /**
     * testStringBuilder 花费:9 ms
     */
    @Test
    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < CIRCLE; i++) {
            sb.append(i);
        }
        sb.toString();
        long endTime = System.currentTimeMillis();
        System.out.println("testStringBuilder 花费:" + (endTime - beginTime) + " ms");
    }

    /**
     * testStringBuffer10 花费:4 ms
     */
    @Test
    public void testStringBuffer10() {
        StringBuffer sb = new StringBuffer(5888890);
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < CIRCLE; i++) {
            sb.append(i);
        }
        sb.toString();
        long endTime = System.currentTimeMillis();
        System.out.println("testStringBuffer10 花费:" + (endTime - beginTime) + " ms");
    }

    /**
     * testStringBuilder10  花费:5 ms
     */
    @Test
    public void testStringBuilder10() {
        StringBuilder sb = new StringBuilder(5888890);
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < CIRCLE; i++) {
            sb.append(i);
        }
        sb.toString();
        long endTime = System.currentTimeMillis();
        System.out.println("testStringBuilder10  花费:" + (endTime - beginTime) + " ms");
    }

}
