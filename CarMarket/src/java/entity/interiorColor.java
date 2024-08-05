/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class interiorColor {
    private int InteriorColorID;
    private String InteriorColorName;

    public interiorColor() {
    }

    public interiorColor(int InteriorColorID, String InteriorColorName) {
        this.InteriorColorID = InteriorColorID;
        this.InteriorColorName = InteriorColorName;
    }

    public interiorColor(String InteriorColorName) {
        this.InteriorColorName = InteriorColorName;
    }

    public int getInteriorColorID() {
        return InteriorColorID;
    }

    public void setInteriorColorID(int InteriorColorID) {
        this.InteriorColorID = InteriorColorID;
    }

    public String getInteriorColorName() {
        return InteriorColorName;
    }

    public void setInteriorColorName(String InteriorColorName) {
        this.InteriorColorName = InteriorColorName;
    }
    
    
}
