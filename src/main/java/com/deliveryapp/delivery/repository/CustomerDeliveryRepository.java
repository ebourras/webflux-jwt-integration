package com.deliveryapp.delivery.repository;

import com.deliveryapp.delivery.model.CustomerDelivery;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CustomerDeliveryRepository extends ReactiveCrudRepository<CustomerDelivery, String> {

    @Query("{ 'customerId' : ?0 }")
    Mono<CustomerDelivery> findCustomerDeliveryByCustomerId(@Param("customerId") String customerId);
}
