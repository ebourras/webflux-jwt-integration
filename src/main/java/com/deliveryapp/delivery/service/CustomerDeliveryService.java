package com.deliveryapp.delivery.service;

import com.deliveryapp.delivery.dto.CustomerDeliveryDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerDeliveryService {

    Mono<CustomerDeliveryDto> saveCustomerDelivery(CustomerDeliveryDto customerDeliveryDto);

    Mono<CustomerDeliveryDto> getCustomerDelivery(String customerId);

    Flux<CustomerDeliveryDto> getAllCustomersDeliveries();

    Mono<CustomerDeliveryDto> updateCustomerDelivery(CustomerDeliveryDto customerDeliveryDto, String customerId);

    Mono<Void> deleteCustomerDelivery(String customerId);
}
