package cn.edu.bupt.ch2.ValueObject_Pattern;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI服务端接口，其中getOrder()方法取得一个Value Object，其他方法均取得Order对象的一部分信息
 *
 * Created by FirenzesEagle on 2016/5/18 0018.
 * Email:liumingbo2008@gmail.com
 */
public interface IOrderManager extends Remote {

    public Order getOrder(int id) throws RemoteException;   //Value Object模式

    public String getClientName(int id) throws RemoteException;
    public String getProductName(int id) throws RemoteException;
    public int getNumber(int id) throws RemoteException;

}
