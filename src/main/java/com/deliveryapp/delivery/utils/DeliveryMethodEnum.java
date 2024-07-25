package com.deliveryapp.delivery.utils;

public enum DeliveryMethodEnum {

    DRIVE("DRIVE"),
    DELIVERY("DELIVERY"),
    DELIVERY_TODAY("DELIVERY_TODAY"),
    DELIVERY_ASAP("DELIVERY_ASAP");

    public final String deliveryMethod;

    DeliveryMethodEnum(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
