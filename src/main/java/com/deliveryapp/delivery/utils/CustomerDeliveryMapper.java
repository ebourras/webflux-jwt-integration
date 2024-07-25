package com.deliveryapp.delivery.utils;

import com.deliveryapp.delivery.dto.CustomerDeliveryDto;
import com.deliveryapp.delivery.model.CustomerDelivery;

public class CustomerDeliveryMapper {

    public static CustomerDeliveryDto mapToCustomerDeliveryDto(CustomerDelivery customerDelivery){
        return new CustomerDeliveryDto(
                customerDelivery.getCustomerId(),
                customerDelivery.getDeliveryMethodId(),
                customerDelivery.getDayOfWeek(),
                customerDelivery.getDeliveryTime()
        );
    }

    public static CustomerDelivery mapToCustomerDelivery(CustomerDeliveryDto customerDeliveryDto){
        return new CustomerDelivery(
                customerDeliveryDto.getId(),
                customerDeliveryDto.getCustomerId(),
                customerDeliveryDto.getDeliveryMethodId(),
                customerDeliveryDto.getDayOfWeek(),
                customerDeliveryDto.getDeliveryTime()
        );
    }
}
