/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class Post {

    private int postId;
    private int userId;
    private int carId;
    private String carName;
    private int originId, gearboxId, engineId, interiorColorId, exteriorColorId, numberOfSeatsId, numberOfDoorsId;
    private float priceCar;
    private Date postDate;
    private boolean status;
    private String descriptions;
    private int year;
    
     private List<CarImage> images;

    public Post() {
    }

    public Post(int postId, int userId, int carId, String carName, int originId, int gearboxId, int engineId, int interiorColorId, int exteriorColorId, int numberOfSeatsId, int numberOfDoorsId, float priceCar, Date postDate, boolean status, String descriptions, int year) {
        this.postId = postId;
        this.userId = userId;
        this.carId = carId;
        this.carName = carName;
        this.originId = originId;
        this.gearboxId = gearboxId;
        this.engineId = engineId;
        this.interiorColorId = interiorColorId;
        this.exteriorColorId = exteriorColorId;
        this.numberOfSeatsId = numberOfSeatsId;
        this.numberOfDoorsId = numberOfDoorsId;
        this.priceCar = priceCar;
        this.postDate = postDate;
        this.status = status;
        this.descriptions = descriptions;
        this.year = year;
    }

    public Post(int userId, int carId, String carName, int originId, int gearboxId, int engineId, int interiorColorId, int exteriorColorId, int numberOfSeatsId, int numberOfDoorsId, float priceCar, Date postDate, boolean status, String descriptions, int year) {
        this.userId = userId;
        this.carId = carId;
        this.carName = carName;
        this.originId = originId;
        this.gearboxId = gearboxId;
        this.engineId = engineId;
        this.interiorColorId = interiorColorId;
        this.exteriorColorId = exteriorColorId;
        this.numberOfSeatsId = numberOfSeatsId;
        this.numberOfDoorsId = numberOfDoorsId;
        this.priceCar = priceCar;
        this.postDate = postDate;
        this.status = status;
        this.descriptions = descriptions;
        this.year = year;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }

    public int getGearboxId() {
        return gearboxId;
    }

    public void setGearboxId(int gearboxId) {
        this.gearboxId = gearboxId;
    }

    public int getEngineId() {
        return engineId;
    }

    public void setEngineId(int engineId) {
        this.engineId = engineId;
    }

    public int getInteriorColorId() {
        return interiorColorId;
    }

    public void setInteriorColorId(int interiorColorId) {
        this.interiorColorId = interiorColorId;
    }

    public int getExteriorColorId() {
        return exteriorColorId;
    }

    public void setExteriorColorId(int exteriorColorId) {
        this.exteriorColorId = exteriorColorId;
    }

    public int getNumberOfSeatsId() {
        return numberOfSeatsId;
    }

    public void setNumberOfSeatsId(int numberOfSeatsId) {
        this.numberOfSeatsId = numberOfSeatsId;
    }

    public int getNumberOfDoorsId() {
        return numberOfDoorsId;
    }

    public void setNumberOfDoorsId(int numberOfDoorsId) {
        this.numberOfDoorsId = numberOfDoorsId;
    }

    public float getPriceCar() {
        return priceCar;
    }

    public void setPriceCar(float priceCar) {
        this.priceCar = priceCar;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
    
    public List<CarImage> getImages() {
        return images;
    }

    public void setImages(List<CarImage> images) {
        this.images = images;
    }

}
