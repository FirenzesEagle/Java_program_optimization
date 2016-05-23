package cn.edu.bupt.ch3.String;

/**
 * str1和str2引用了相同的地址，但是str3却重新开辟了一块内存空间
 * 但是即便如此，str3在常量池中的位置和str1是一样的
 *
 * Created by FirenzesEagle on 2016/5/23 0023.
 * Email:liumingbo2008@gmail.com
 */
public class SameValueString {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        System.out.println(str1 == str2); //返回true
        System.out.println(str1 == str3); //返回false
        System.out.println(str1 == str3.intern());    //返回true
    }

}
