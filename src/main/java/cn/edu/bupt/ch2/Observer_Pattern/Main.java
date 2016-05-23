package cn.edu.bupt.ch2.Observer_Pattern;

/**
 * Created by FirenzesEagle on 2016/5/18 0018.
 * Email:liumingbo2008@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        ConcreteSubject weatherData = new ConcreteSubject();
        IObserver conditionsDisplay = new ConcreteObserver(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 78, 40.4f);

    }

}
