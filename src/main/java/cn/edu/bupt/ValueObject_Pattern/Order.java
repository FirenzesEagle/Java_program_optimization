package cn.edu.bupt.ValueObject_Pattern;

import java.io.Serializable;

/**
 * 作为Value Object的Order对象
 * <p>
 * Created by FirenzesEagle on 2016/5/18 0018.
 * Email:liumingbo2008@gmail.com
 */
public class Order implements Serializable {
    private int orderId;
    private String clientName;
    private int number;
    private String productName;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
