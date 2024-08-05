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
public class Car {
    private int CarId;
    private int brandId;
    private int modelId;
    private int UserId;

    public Car() {
    }

    public Car(int CarId, int brandId, int modelId, int UserId) {
        this.CarId = CarId;
        this.brandId = brandId;
        this.modelId = modelId;
        this.UserId = UserId;
    }

    public Car(int brandId, int modelId, int UserId) {
        this.brandId = brandId;
        this.modelId = modelId;
        this.UserId = UserId;
    }

    public int getCarId() {
        return CarId;
    }

    public void setCarId(int CarId) {
        this.CarId = CarId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }
  

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
    
    
}
