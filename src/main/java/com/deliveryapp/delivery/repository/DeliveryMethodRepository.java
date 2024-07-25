package com.deliveryapp.delivery.repository;

import com.deliveryapp.delivery.model.DeliveryMethod;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DeliveryMethodRepository extends ReactiveCrudRepository<DeliveryMethod, String> {
}

