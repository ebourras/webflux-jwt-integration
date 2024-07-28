package com.deliveryapp.delivery.dto;

import com.deliveryapp.delivery.utils.DeliveryMethodEnum;

import java.util.Date;

public class DeliveryMethodDto {

    private String deliveryMethodId;
    private DeliveryMethodEnum deliveryMethodName;
    private Date startTime;

    private Date endTime;

    public DeliveryMethodDto(String deliveryMethodId, DeliveryMethodEnum deliveryMethodName, Date startTime, Date endTime) {
        this.deliveryMethodId = deliveryMethodId;
        this.deliveryMethodName = deliveryMethodName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DeliveryMethodDto() {

    }

    public String getDeliveryMethodId() {
        return deliveryMethodId;
    }

    public void setDeliveryMethodId(String deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }

    public DeliveryMethodEnum getDeliveryMethodName() {
        return deliveryMethodName;
    }

    public void setDeliveryMethodName(DeliveryMethodEnum deliveryMethodName) {
        this.deliveryMethodName = deliveryMethodName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}

