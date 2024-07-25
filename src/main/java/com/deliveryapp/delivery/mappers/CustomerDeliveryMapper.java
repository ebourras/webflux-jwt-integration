package com.deliveryapp.delivery.mappers;

import com.deliveryapp.delivery.dto.CustomerDeliveryDto;
import com.deliveryapp.delivery.model.CustomerDelivery;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerDeliveryMapper {

    CustomerDeliveryMapper INSTANCE = Mappers.getMapper(CustomerDeliveryMapper.class);

    CustomerDeliveryDto mapCustomerDeliveryToDto(CustomerDelivery Customer);
    CustomerDelivery mapDtoToCustomerDelivery(CustomerDeliveryDto dto);
}
