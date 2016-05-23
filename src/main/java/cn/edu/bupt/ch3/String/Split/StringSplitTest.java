package cn.edu.bupt.ch3.String.Split;

import org.junit.Test;

import java.util.StringTokenizer;

/**
 * Created by FirenzesEagle on 2016/5/23 0023.
 * Email:liumingbo2008@gmail.com
 */
public class StringSplitTest {

    /**
     * String.split()方法使用简单，功能强大
     * 但是在性能敏感的系统中频繁使用这个方法是不可取的，建议使用效率更高的StringTokenizer类
     */
    @Test
    public void testSplit() {
        String orgStr = null;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            stringBuffer.append(i);
            stringBuffer.append(";");
        }
        orgStr = stringBuffer.toString();

        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            orgStr.split(";");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testSplit 花费:" + (endTime - beginTime) + " ms");
    }

    /**
     * 效率较split()高，在经常需要字符串拆分的地方可以优先考虑使用此方法
     */
    @Test
    public void testToken() {
        String orgStr = null;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            stringBuffer.append(i);
            stringBuffer.append(";");
        }
        orgStr = stringBuffer.toString();

        long beginTime = System.currentTimeMillis();
        StringTokenizer st = new StringTokenizer(orgStr, ";");
        for (int i = 0; i < 10000; i++) {
            while (st.hasMoreTokens()) {
                st.nextToken();
            }
            st = new StringTokenizer(orgStr, ";");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testSplit 花费:" + (endTime - beginTime) + " ms");
    }

    /**
     * testIndexOf 花费:6419 ms
     * 本例中书中介绍是性能最优算法，可是测试中性能是最差的
     */
    @Test
    public void testIndexOf() {
        String orgStr = null;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            stringBuffer.append(i);
            stringBuffer.append(";");
        }
        orgStr = stringBuffer.toString();

        long beginTime = System.currentTimeMillis();
        String tmp = orgStr;
        for (int i = 0; i < 10000; i++) {
            while (true) {
                String splitStr = null;
                int j = tmp.indexOf(';');
                if (j < 0) break;
                splitStr = tmp.substring(0, j);
                tmp = tmp.substring(j + 1);
            }
            tmp = orgStr;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testIndexOf 花费:" + (endTime - beginTime) + " ms");

    }

}
