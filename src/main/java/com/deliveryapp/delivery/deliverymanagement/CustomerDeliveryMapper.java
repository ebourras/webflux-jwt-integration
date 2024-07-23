package com.deliveryapp.delivery.deliverymanagement;

import com.deliveryapp.delivery.delivery.DeliveryMethod;
import com.deliveryapp.delivery.delivery.DeliveryMethodDto;

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
