/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class engine {
    private int EngineID;
    private String EngineName;

    public engine() {
    }

    public engine(int EngineID, String EngineName) {
        this.EngineID = EngineID;
        this.EngineName = EngineName;
    }

    public engine(String EngineName) {
        this.EngineName = EngineName;
    }

    public int getEngineID() {
        return EngineID;
    }

    public void setEngineID(int EngineID) {
        this.EngineID = EngineID;
    }

    public String getEngineName() {
        return EngineName;
    }

    public void setEngineName(String EngineName) {
        this.EngineName = EngineName;
    }
    
    
}
