package cn.edu.bupt.Observer_Pattern;

/**
 * 观察者接口：观察者接口定义了观察者的基本方法。当依赖状态发生改变时，主题接口就会调用观察者的update()方法
 *
 * Created by FirenzesEagle on 2016/5/17 0017.
 * Email:liumingbo2008@gmail.com
 */
public interface IObserver {

    void  update(float temperature,float humidity,float pressure);

}
