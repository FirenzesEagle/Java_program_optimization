package cn.edu.bupt.ch2.ValueObject_Pattern;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by FirenzesEagle on 2016/5/18 0018.
 * Email:liumingbo2008@gmail.com
 */
public class OrderManager extends UnicastRemoteObject implements IOrderManager {

    protected OrderManager() throws RemoteException {
        super();
    }

    /**
     * @param id
     * @return 订单信息
     * @throws RemoteException
     */
    @Override
    public Order getOrder(int id) throws RemoteException {
        Order order = new Order();
        order.setClientName("billy");
        order.setNumber(20);
        order.setProductName("desk");
        return order;
    }

    @Override
    public String getClientName(int id) throws RemoteException {
        return "billy";
    }

    @Override
    public String getProductName(int id) throws RemoteException {
        return "desk";
    }

    @Override
    public int getNumber(int id) throws RemoteException {
        return 20;
    }

}
