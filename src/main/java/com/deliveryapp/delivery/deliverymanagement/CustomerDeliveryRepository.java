package com.deliveryapp.delivery.deliverymanagement;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

public interface CustomerDeliveryRepository extends ReactiveCrudRepository<CustomerDelivery, String> {

    Flux<CustomerDelivery> findByCustomerId(String customerId);
}
