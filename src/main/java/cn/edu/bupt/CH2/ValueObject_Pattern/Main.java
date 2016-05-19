package cn.edu.bupt.ch2.ValueObject_Pattern;

import java.rmi.Naming;

/**
 * Created by FirenzesEagle on 2016/5/18 0018.
 * Email:liumingbo2008@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        try {
            IOrderManager userManager = (IOrderManager) Naming.lookup("OrderManager");
            Long begin = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                userManager.getOrder(i);
            }
            System.out.println("getOrder spend: " + (System.currentTimeMillis()-begin));
            begin = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                userManager.getClientName(i);
                userManager.getNumber(i);
                userManager.getProductName(i);
            }
            System.out.println("3 Method call spend: " + (System.currentTimeMillis()-begin));
            System.out.println(userManager.getOrder(0).getClientName());
        } catch (Exception e) {
            System.out.println("OrderManager exception: " + e);
        }
    }

}
