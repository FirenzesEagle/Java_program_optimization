package cn.edu.bupt.Observer_Pattern;

/**
 * 主题接口：指被观察的对象。当其状态发生改变或者某事件发生时，他会将这个变化通知观察者。它维护了观察者所需要依赖的状态。
 *
 * Created by FirenzesEagle on 2016/5/17 0017.
 * Email:liumingbo2008@gmail.com
 */
public interface ISubject {

    void attach(IObserver observer);    //添加观察者

    void detach(IObserver observer);    //删除观察者

    void inform();  //通知所有观察者

}
