/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class exteriorColor {
    private int ExteriorColorID;
    private String ExteriorColorName;

    public exteriorColor() {
    }

    public exteriorColor(int ExteriorColorID, String ExteriorColorName) {
        this.ExteriorColorID = ExteriorColorID;
        this.ExteriorColorName = ExteriorColorName;
    }

    public exteriorColor(String ExteriorColorName) {
        this.ExteriorColorName = ExteriorColorName;
    }

    public int getExteriorColorID() {
        return ExteriorColorID;
    }

    public void setExteriorColorID(int ExteriorColorID) {
        this.ExteriorColorID = ExteriorColorID;
    }

    public String getExteriorColorName() {
        return ExteriorColorName;
    }

    public void setExteriorColorName(String ExteriorColorName) {
        this.ExteriorColorName = ExteriorColorName;
    }
    
    
}
