package cn.edu.bupt.ch3.String.Split;

import org.junit.Test;

/**
 * 测试charAt()比StartWith的效率高
 *
 * Created by FirenzesEagle on 2016/5/23 0023.
 * Email:liumingbo2008@gmail.com
 */
public class StrCharAtStartTest {

    @Test
    public void testCharAt() {
        String orgStr = null;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
            sb.append(";");
        }
        orgStr = sb.toString();
        int len = orgStr.length();

        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            if (orgStr.charAt(0) == 'a' && orgStr.charAt(1) == 'b' && orgStr.charAt(2) == 'c') ;
            if (orgStr.charAt(len - 1) == 'a' && orgStr.charAt(len - 2) == 'b' && orgStr.charAt(len - 3) == 'c') ;
        }
        long endTime = System.currentTimeMillis();

        System.out.println("testCharAt 花费:" + (endTime - beginTime) + " ms");
    }

    @Test
    public void testStartWith() {
        String orgStr = null;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
            sb.append(";");
        }
        orgStr = sb.toString();
        int len = orgStr.length();

        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            orgStr.startsWith("abc");
            orgStr.endsWith("abc");
        }
        long endTime = System.currentTimeMillis();

        System.out.println("testStartWith 花费:" + (endTime - beginTime) + " ms");
    }

}
