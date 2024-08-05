/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class CarImage {
    private int ImageID;
    private int postId;
    private String postImg;

    public CarImage() {
    }

    public CarImage(int ImageID, int postId, String postImg) {
        this.ImageID = ImageID;
        this.postId = postId;
        this.postImg = postImg;
    }

    public CarImage(int postId, String postImg) {
        this.postId = postId;
        this.postImg = postImg;
    }

    public CarImage(String postImg) {
        this.postImg = postImg;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int ImageID) {
        this.ImageID = ImageID;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }
    
    
}
