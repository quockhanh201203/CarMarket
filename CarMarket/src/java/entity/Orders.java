/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Orders {
    private int OrderId;
    private float deposits;
    private Date order_date;
    private int carId;
    private int userId;

    public Orders() {
    }

    public Orders(int OrderId, float deposits, Date order_date, int carId, int userId) {
        this.OrderId = OrderId;
        this.deposits = deposits;
        this.order_date = order_date;
        this.carId = carId;
        this.userId = userId;
    }

    public Orders(float deposits, Date order_date, int carId, int userId) {
        this.deposits = deposits;
        this.order_date = order_date;
        this.carId = carId;
        this.userId = userId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public float getDeposits() {
        return deposits;
    }

    public void setDeposits(float deposits) {
        this.deposits = deposits;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    
}
