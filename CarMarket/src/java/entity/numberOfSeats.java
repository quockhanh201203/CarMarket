/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class numberOfSeats {
    private int NumberOfSeatsID;
    private String NumberOfSeatsName;

    public numberOfSeats() {
    }

    public numberOfSeats(int NumberOfSeatsID, String NumberOfSeatsName) {
        this.NumberOfSeatsID = NumberOfSeatsID;
        this.NumberOfSeatsName = NumberOfSeatsName;
    }

    public numberOfSeats(String NumberOfSeatsName) {
        this.NumberOfSeatsName = NumberOfSeatsName;
    }

    public int getNumberOfSeatsID() {
        return NumberOfSeatsID;
    }

    public void setNumberOfSeatsID(int NumberOfSeatsID) {
        this.NumberOfSeatsID = NumberOfSeatsID;
    }

    public String getNumberOfSeatsName() {
        return NumberOfSeatsName;
    }

    public void setNumberOfSeatsName(String NumberOfSeatsName) {
        this.NumberOfSeatsName = NumberOfSeatsName;
    }
    
    
}
