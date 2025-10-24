package com.paypal.transaction_service.dto;

public class TransactionRequest {
    
    private Long senderId;
    private Long receiverId;
    private Double amount;

    public TransactionRequest() {}

    public TransactionRequest(Long senderId, Long receiverId, Double amount){
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
    }

    public void setSenderId(Long senderId){
        this.senderId = senderId;
    }

    public void setReceiverId(Long receiverId){
        this.receiverId = receiverId;
    }

    public void setAmount(Double amount){
        this.amount = amount;
    }

    public Long getSenderId(){
        return senderId;
    }

    public Long getReceiverId(){
        return receiverId;
    }

    public Double getAmount(){
        return amount;
    }

}
