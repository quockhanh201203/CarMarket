/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Origin {
    private int OriginID;
    private String OriginName;

    public Origin() {
    }

    public Origin(int OriginID, String OriginName) {
        this.OriginID = OriginID;
        this.OriginName = OriginName;
    }

    public Origin(String OriginName) {
        this.OriginName = OriginName;
    }

    public int getOriginID() {
        return OriginID;
    }

    public void setOriginID(int OriginID) {
        this.OriginID = OriginID;
    }

    public String getOriginName() {
        return OriginName;
    }

    public void setOriginName(String OriginName) {
        this.OriginName = OriginName;
    }
    
    
}
