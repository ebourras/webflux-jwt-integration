package com.deliveryapp.delivery.mappers;

import com.deliveryapp.delivery.dto.CustomerDto;
import com.deliveryapp.delivery.dto.DeliveryMethodDto;
import com.deliveryapp.delivery.model.Customer;
import com.deliveryapp.delivery.model.DeliveryMethod;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryMethodMapper {

    DeliveryMethodMapper INSTANCE = Mappers.getMapper(DeliveryMethodMapper.class);

    DeliveryMethodDto mapDeliveryMethodToDto(DeliveryMethod Customer);
    DeliveryMethod mapDtoToDeliveryMethod(DeliveryMethodDto dto);
}
