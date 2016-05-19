package cn.edu.bupt.ch2.Flyweight_Pattern;

/**
 * 抽象享元：定义需共享的对象的业务员接口
 * 享元类被创建出来总是为了实现某些特定的业务逻辑，而抽象享元便定义这些逻辑的语义行为
 *
 * 本例中用来创建一个报表
 *
 * Created by FirenzesEagle on 2016/5/16 0016.
 * Email:liumingbo2008@gmail.com
 */
public interface IReportManager {

    public String createReport();

}
