package com.deliveryapp.delivery.mappers;

import com.deliveryapp.delivery.dto.CustomerDto;
import com.deliveryapp.delivery.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto mapCustomerToDto(Customer Customer);
    Customer mapDtoToCustomer(CustomerDto dto);

}
