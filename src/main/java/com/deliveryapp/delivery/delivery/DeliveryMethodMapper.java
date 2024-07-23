package com.deliveryapp.delivery.delivery;

import com.deliveryapp.delivery.customer.Customer;
import com.deliveryapp.delivery.customer.CustomerDto;

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
