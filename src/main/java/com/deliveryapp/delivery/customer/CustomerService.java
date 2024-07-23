package com.deliveryapp.delivery.customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Mono<CustomerDto> saveCustomer(CustomerDto customerDto);

    Mono<CustomerDto> getCustomer(String customerId);

    Flux<CustomerDto> getAllCustomers();

    Mono<CustomerDto> updateCustomer(CustomerDto customerDto, String customerId);

    Mono<Void> deleteCustomer(String customerId);
}
