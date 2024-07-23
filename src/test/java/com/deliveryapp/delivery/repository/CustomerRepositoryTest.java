package com.deliveryapp.delivery.repository;

import com.deliveryapp.delivery.customer.Customer;
import com.deliveryapp.delivery.customer.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void when_one_customer_then_should_have_single_client() {

        // Given
        Customer customer = createCustomer();

        // When
        Publisher<Customer> setup = repository.deleteAll().thenMany(repository.save(customer));

        // Then
        StepVerifier
                .create(setup)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    public void should_save_customer(){

        // Given
        Customer customer = createCustomer();

        // When
        Publisher<Customer> setup = repository.deleteAll().then(repository.save(customer));
        Mono<Customer> find  = repository.findById(customer.getCustomerId());

        // Then
        Publisher<Customer> composite = Mono
                .from(setup)
                .then(find);
        StepVerifier
                .create(composite)
                .consumeNextWith(customer1 -> {
                    assertNotNull(customer1.getCustomerId());
                    assertEquals(customer1.getEmail(), "elmehdi.bourras@gmail.com");
                    assertEquals(customer1.getFirstName(), "mehdi");
                    assertEquals(customer1.getLastName(), "bourras");
                })
                .verifyComplete();

    }

    private Customer createCustomer() {

        Customer customer = new Customer();
        customer.setCustomerId(UUID.randomUUID().toString());
        customer.setFirstName("mehdi");
        customer.setLastName("bourras");
        customer.setEmail("elmehdi.bourras@gmail.com");

        return customer;
    }
}
