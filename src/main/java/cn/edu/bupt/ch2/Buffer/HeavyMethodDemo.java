package cn.edu.bupt.ch2.Buffer;

/**
 * 会被频繁调用，需要加入到缓存中的因式分解类
 * <p>
 * Created by FirenzesEagle on 2016/5/19 0019.
 * Email:liumingbo2008@gmail.com
 */
public class HeavyMethodDemo {

    public String heavyMethod(int num) {
        int i;
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        for (i = 2; i <= num; i++) {

            if (flag == true) {
                sb.append("*");
                flag = false;
            }
            if (num % i == 0) {
                sb.append(i);
                flag = true;
                num = num / i;
                while (num % i == 0) {
                    num = num / i;

                    if (flag == true) {
                        sb.append("*");
                        flag = false;
                    }
                    sb.append(i);
                    flag = true;

                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HeavyMethodDemo heavyMethodDemo = new HeavyMethodDemo();
        System.out.println(heavyMethodDemo.heavyMethod(100));
        System.out.println(Integer.MAX_VALUE - 1);
    }

}
