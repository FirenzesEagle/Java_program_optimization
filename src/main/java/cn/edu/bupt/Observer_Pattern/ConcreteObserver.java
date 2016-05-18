package cn.edu.bupt.Observer_Pattern;

/**
 * 具体观察者：实现了观察者接口的update()方法，具体处理当被观察者状态改变或者某一事件发生时的业务逻辑
 *
 * Created by FirenzesEagle on 2016/5/18 0018.
 * Email:liumingbo2008@gmail.com
 */
public class ConcreteObserver implements IObserver {

    private float temperature;
    private float humidity;
    private float pressure;

    private ISubject weatherData;

    public ConcreteObserver(ISubject weatherData) {
        this.weatherData = weatherData;
        weatherData.attach(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Current conditions:" + temperature + "F degrees and " + humidity + "% humidity and " + pressure + "P pressure");
    }
}
