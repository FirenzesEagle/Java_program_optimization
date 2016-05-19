package cn.edu.bupt.ch2.Proxy_Pattern;

/**
 * 代理类：用来代理和封装真实主题
 *
 * Created by FirenzesEagle on 2016/5/13 0013.
 * Email:liumingbo2008@gmail.com
 */
public class DBQueryProxy implements IDBQuery {

    private DBQuery dbQuery = null;

    @Override
    public String request() {
        //在真正需要的时候，才创建真实对象，创建过程可能很慢
        if(dbQuery == null){
            dbQuery = new DBQuery();
        }
        //在多线程环境下，这里返回一个虚假类，类似于Future模式
        return dbQuery.request();
    }
}
