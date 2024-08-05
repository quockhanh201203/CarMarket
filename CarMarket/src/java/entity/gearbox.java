/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class gearbox {
    private int GearboxID;
    private String GearboxName;

    public gearbox() {
    }

    public gearbox(int GearboxID, String GearboxName) {
        this.GearboxID = GearboxID;
        this.GearboxName = GearboxName;
    }

    public gearbox(String GearboxName) {
        this.GearboxName = GearboxName;
    }

    public int getGearboxID() {
        return GearboxID;
    }

    public void setGearboxID(int GearboxID) {
        this.GearboxID = GearboxID;
    }

    public String getGearboxName() {
        return GearboxName;
    }

    public void setGearboxName(String GearboxName) {
        this.GearboxName = GearboxName;
    }
    
    
}
