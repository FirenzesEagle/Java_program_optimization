package cn.edu.bupt.ch3.String.Split;

import org.junit.Test;

/**
 * 测试使用正则表达式用split()方法拆分字符串
 *
 * Created by FirenzesEagle on 2016/5/23 0023.
 * Email:liumingbo2008@gmail.com
 */
public class StringSplitFunctionTest {

    @Test
    public void testSplit() {
        String str="a;b,c:d";
        String re[]="a;b,c:d".split("[;|,|:]");
        for(String s:re){
            System.out.println(s);
        }
    }

}
