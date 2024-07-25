package com.deliveryapp.delivery.repository;

import com.deliveryapp.delivery.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {
}
