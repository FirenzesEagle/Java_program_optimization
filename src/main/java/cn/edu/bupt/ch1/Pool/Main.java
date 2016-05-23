package cn.edu.bupt.ch1.Pool;

/**
 * Created by FirenzesEagle on 2016/5/21 0021.
 * Email:liumingbo2008@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        new ObjectPoolDemo.PoolThread().start();
        new ObjectPoolDemo.PoolThread().start();
        new ObjectPoolDemo.PoolThread().start();

        try {
            while (true){
                if (ObjectPoolDemo.endCount.get() == 3){    //等待3个线程全部结束
                    ObjectPoolDemo.pool.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
