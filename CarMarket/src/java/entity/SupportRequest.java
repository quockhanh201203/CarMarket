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
public class SupportRequest {
    private int SupportRequestId;
    private int ClientId;
    private String message;
    private Date createDate;
    private String responseMessage;

    public SupportRequest() {
    }

    public SupportRequest(int SupportRequestId, int ClientId, String message, Date createDate, String responseMessage) {
        this.SupportRequestId = SupportRequestId;
        this.ClientId = ClientId;
        this.message = message;
        this.createDate = createDate;
        this.responseMessage = responseMessage;
    }

    public SupportRequest(int ClientId, String message, Date createDate, String responseMessage) {
        this.ClientId = ClientId;
        this.message = message;
        this.createDate = createDate;
        this.responseMessage = responseMessage;
    }

    public int getSupportRequestId() {
        return SupportRequestId;
    }

    public void setSupportRequestId(int SupportRequestId) {
        this.SupportRequestId = SupportRequestId;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int ClientId) {
        this.ClientId = ClientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    
    
}
