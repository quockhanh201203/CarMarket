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
public class Membership {
    private int MembershipId;
    private String nameShowroom;
    private boolean status;
    private Date startDate;
    private Date endDate;
    private int membershipType;
    private int userId;

    public Membership() {
    }

    public Membership(int MembershipId, String nameShowroom, boolean status, Date startDate, Date endDate, int membershipType, int userId) {
        this.MembershipId = MembershipId;
        this.nameShowroom = nameShowroom;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.membershipType = membershipType;
        this.userId = userId;
    }

    public Membership(String nameShowroom, boolean status, Date startDate, Date endDate, int membershipType, int userId) {
        this.nameShowroom = nameShowroom;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.membershipType = membershipType;
        this.userId = userId;
    }

    public int getMembershipId() {
        return MembershipId;
    }

    public void setMembershipId(int MembershipId) {
        this.MembershipId = MembershipId;
    }

    public String getNameShowroom() {
        return nameShowroom;
    }

    public void setNameShowroom(String nameShowroom) {
        this.nameShowroom = nameShowroom;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(int membershipType) {
        this.membershipType = membershipType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
