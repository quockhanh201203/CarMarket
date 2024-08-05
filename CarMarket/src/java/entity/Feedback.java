/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Feedback {
    private int FeedbackId;
    private String note;
    private String rank;
    private Date createDate;
    private int userId;

    public Feedback() {
    }

    public Feedback(int FeedbackId, String note, String rank, Date createDate, int userId) {
        this.FeedbackId = FeedbackId;
        this.note = note;
        this.rank = rank;
        this.createDate = createDate;
        this.userId = userId;
    }

    public Feedback(String note, String rank, Date createDate) {
        this.note = note;
        this.rank = rank;
        this.createDate = createDate;
    }

    public Feedback(String note, String rank, Date createDate, int userId) {
        this.note = note;
        this.rank = rank;
        this.createDate = createDate;
        this.userId = userId;
    }
    
    

    public int getFeedbackId() {
        return FeedbackId;
    }

    public void setFeedbackId(int FeedbackId) {
        this.FeedbackId = FeedbackId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
