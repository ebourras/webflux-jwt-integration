package com.deliveryapp.delivery.service;

import com.deliveryapp.delivery.customer.Customer;
import com.deliveryapp.delivery.customer.CustomerDto;
import com.deliveryapp.delivery.customer.CustomerRepository;
import com.deliveryapp.delivery.customer.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;


    @Test
    public void should_return_customer() {

        // Given
        Customer customer = createCustomer();

        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Mono.just(customer));

        // When
        Mono<CustomerDto> customerDtoMono = customerService.getCustomer(customer.getCustomerId());

        // Then
        StepVerifier
                .create(customerDtoMono)
                .consumeNextWith(newCustomer -> {
                    assertEquals(newCustomer.getEmail(), "elmehdi.bourras@gmail.com");
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
