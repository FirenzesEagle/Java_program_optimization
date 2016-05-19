package cn.edu.bupt.ch2.Proxy_Pattern;

/**
 * 主题接口：定义代理类和真实主题的公共对外方法，也是代理类代理真实主题的方法
 *
 * Created by FirenzesEagle on 2016/5/13 0013.
 * Email:liumingbo2008@gmail.com
 */
public interface IDBQuery {
    String request();
}
