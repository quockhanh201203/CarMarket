/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Model {
    private int ModelId;
    private String ModelName;
    private String ModelImg;

    public Model() {
    }

    public Model(int ModelId, String ModelName, String ModelImg) {
        this.ModelId = ModelId;
        this.ModelName = ModelName;
        this.ModelImg = ModelImg;
    }

    public Model(String ModelName) {
        this.ModelName = ModelName;
    }

    public int getModelId() {
        return ModelId;
    }

    public void setModelId(int ModelId) {
        this.ModelId = ModelId;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String ModelName) {
        this.ModelName = ModelName;
    }

    public String getModelImg() {
        return ModelImg;
    }

    public void setModelImg(String ModelImg) {
        this.ModelImg = ModelImg;
    }
    
    
    
    
}
