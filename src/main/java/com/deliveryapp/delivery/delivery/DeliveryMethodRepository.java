package com.deliveryapp.delivery.delivery;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DeliveryMethodRepository extends ReactiveCrudRepository<DeliveryMethod, String> {
}

