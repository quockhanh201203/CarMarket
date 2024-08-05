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
public class Provider {
    private int ProviderId;
    private String email;
    private String password;
    private int role;
    private Date createDate;
    private boolean status;

    public Provider() {
    }

    public Provider(int ProviderId, String email, String password, int role, Date createDate, boolean status) {
        this.ProviderId = ProviderId;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createDate = createDate;
        this.status = status;
    }

    public Provider(String email, String password, int role, Date createDate, boolean status) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.createDate = createDate;
        this.status = status;
    }

    public int getProviderId() {
        return ProviderId;
    }

    public void setProviderId(int ProviderId) {
        this.ProviderId = ProviderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
