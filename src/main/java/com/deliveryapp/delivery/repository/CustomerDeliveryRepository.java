package com.deliveryapp.delivery.repository;

import com.deliveryapp.delivery.model.CustomerDelivery;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CustomerDeliveryRepository extends ReactiveCrudRepository<CustomerDelivery, String> {

    Flux<CustomerDelivery> findByCustomerId(String customerId);
}
