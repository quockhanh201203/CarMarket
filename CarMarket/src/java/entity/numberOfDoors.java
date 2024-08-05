/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class numberOfDoors {
    private int NumberOfDoorsID;
    private String NumberOfDoorsName;

    public numberOfDoors() {
    }

    public numberOfDoors(int NumberOfDoorsID, String NumberOfDoorsName) {
        this.NumberOfDoorsID = NumberOfDoorsID;
        this.NumberOfDoorsName = NumberOfDoorsName;
    }

    public numberOfDoors(String NumberOfDoorsName) {
        this.NumberOfDoorsName = NumberOfDoorsName;
    }

    public int getNumberOfDoorsID() {
        return NumberOfDoorsID;
    }

    public void setNumberOfDoorsID(int NumberOfDoorsID) {
        this.NumberOfDoorsID = NumberOfDoorsID;
    }

    public String getNumberOfDoorsName() {
        return NumberOfDoorsName;
    }

    public void setNumberOfDoorsName(String NumberOfDoorsName) {
        this.NumberOfDoorsName = NumberOfDoorsName;
    }
    
    
}
