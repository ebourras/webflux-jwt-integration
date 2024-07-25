package com.deliveryapp.delivery.utils;

import com.deliveryapp.delivery.dto.DeliveryMethodDto;
import com.deliveryapp.delivery.model.DeliveryMethod;

public class DeliveryMethodMapper {

    public static DeliveryMethodDto mapToDeliveryMethodDto(DeliveryMethod deliveryMethod){
        return new DeliveryMethodDto(
                deliveryMethod.getDeliveryMethodId(),
                deliveryMethod.getDeliveryMethodName(),
                deliveryMethod.getStartTime(),
                deliveryMethod.getEndTime()
        );
    }

    public static DeliveryMethod mapToDeliveryMethod(DeliveryMethodDto deliveryMethodDto){
        return new DeliveryMethod(
                deliveryMethodDto.getDeliveryMethodId(),
                deliveryMethodDto.getDeliveryMethodName(),
                deliveryMethodDto.getStartTime(),
                deliveryMethodDto.getEndTime()
        );
    }
}
