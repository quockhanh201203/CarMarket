/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Brand {
    private int BrandId;
    private String BrandName;
    private String BrandImg;
    public Brand() {
    }

    public Brand(int BrandId, String BrandName, String BrandImg ) {
        this.BrandId = BrandId;
        this.BrandName = BrandName;
        this.BrandImg = BrandImg;
    }

    public Brand(String BrandName) {
        this.BrandName = BrandName;
    }

    public int getBrandId() {
        return BrandId;
    }

    public void setBrandId(int BrandId) {
        this.BrandId = BrandId;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    public String getBrandImg() {
        return BrandImg;
    }

    public void setBrandImg(String BrandImg) {
        this.BrandImg = BrandImg;
    }

    public Brand(String BrandName, String BrandImg) {
        this.BrandName = BrandName;
        this.BrandImg = BrandImg;
    }
    
    
    
}
