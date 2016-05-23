package cn.edu.bupt.ch1.ValueObject_Pattern;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * 业务逻辑层注册并开启RMI服务器
 * <p>
 * Created by FirenzesEagle on 2016/5/18 0018.
 * Email:liumingbo2008@gmail.com
 */
public class OrderManagerServer {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);    //注册RMI端口
            IOrderManager userManager = new OrderManager(); //RMI远程对象
            Naming.rebind("OrderManager", userManager); //绑定RMI对象
            System.out.println("OrderManager is ready.");
        } catch (Exception e) {
            System.out.println("OrderManager Server failed: " + e);
        }
    }

}
