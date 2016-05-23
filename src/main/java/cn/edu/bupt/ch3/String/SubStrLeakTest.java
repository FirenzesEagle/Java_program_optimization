package cn.edu.bupt.ch3.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Tips：书本上的jdk版本的String(char value[], int offset, int count)构造方法实现已经过时
 * 新版本的jdk(1.8)中构造函数的实现已经使用Arrays.copyOfRange(value, offset, offset+count);方式做了处理，不会出现OOM
 *
 * Created by FirenzesEagle on 2016/5/23 0023.
 * Email:liumingbo2008@gmail.com
 */
public class SubStrLeakTest {
    public static void main(String[] args) {
        List<String> handler = new ArrayList<String>();

        /**
         * 原书：
         * Huge不到1000 次 就oom
         * 但是ImprovedHuge 不会
         */
        for (int i = 0; i < 1000; i++) {
            // HugeStr h = new HugeStr();
            ImprovedHugeStr h = new ImprovedHugeStr();
            handler.add(h.getSubString(1, 5));
        }
    }

    static class HugeStr {
        private String str = new String(new char[100000]);

        public String getSubString(int begin, int end) {
            return str.substring(begin, end);   //截取字符串，有溢出
        }
    }

    static class ImprovedHugeStr {
        private String str = new String(new char[100000]);

        public String getSubString(int begin, int end) {
            return new String(str.substring(begin, end));   //截取子字符串，并重新生成，无溢出
        }
    }
}
