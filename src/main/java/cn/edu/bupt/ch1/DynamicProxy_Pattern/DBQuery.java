package cn.edu.bupt.ch1.DynamicProxy_Pattern;

/**
 * 真实主题：真正实现业务逻辑的类
 *
 * Created by FirenzesEagle on 2016/5/13 0013.
 * Email:liumingbo2008@gmail.com
 */
public class DBQuery implements IDBQuery {

    public DBQuery() {
        try {
            Thread.sleep(1000); //可能包含数据库连接等耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "request string";
    }
}
