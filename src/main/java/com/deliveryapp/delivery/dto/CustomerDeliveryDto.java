package com.deliveryapp.delivery.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class CustomerDeliveryDto {

    private String id;
    private String customerId;
    private String deliveryMethodId;

    private DayOfWeek dayOfWeek;
    private LocalTime deliveryTime;

    public CustomerDeliveryDto(String customerId, String deliveryMethodId,DayOfWeek dayOfWeek, LocalTime deliveryTime) {
        this.customerId = customerId;
        this.deliveryMethodId = deliveryMethodId;
        this.dayOfWeek = dayOfWeek;
        this.deliveryTime = deliveryTime;
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDeliveryMethodId() {
        return deliveryMethodId;
    }

    public void setDeliveryMethodId(String deliveryMethod) {
        this.deliveryMethodId = deliveryMethod;
    }

    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
