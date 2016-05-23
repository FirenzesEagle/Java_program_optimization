package cn.edu.bupt.ch1.Observer_Pattern;

import java.util.Vector;

/**
 * 具体主题：具体主题实现了主题接口中的方法。
 * 如新增观察者、删除观察者和通知观察者。其内部维护一个观察者列表。
 * <p>
 * Created by FirenzesEagle on 2016/5/17 0017.
 * Email:liumingbo2008@gmail.com
 */
public class ConcreteSubject implements ISubject {

    Vector<IObserver> observers = new Vector<IObserver>();
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void attach(IObserver observer) {
        observers.addElement(observer);
    }

    @Override
    public void detach(IObserver observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(observer);
        }
    }

    @Override
    public void inform() {
        for (IObserver observer : observers) {
            observer.update(temperature, pressure, humidity);
        }
    }

    public void setMeasurements(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        measurementChanged();
    }

    /**
     * 气象站得到更新的观测数据时，通知观察者
     */
    public void measurementChanged() {
        inform();
    }

}
