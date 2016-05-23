package cn.edu.bupt.ch1.Proxy_Pattern;

/**
 * Created by FirenzesEagle on 2016/5/13 0013.
 * Email:liumingbo2008@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        IDBQuery idbQuery = new DBQueryProxy(); //使用代理
        idbQuery.request(); //在真正使用时才创建真实对象
    }

}
