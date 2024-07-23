package com.deliveryapp.delivery.controller;

import com.deliveryapp.delivery.customer.CustomerController;
import com.deliveryapp.delivery.customer.CustomerDto;
import com.deliveryapp.delivery.customer.CustomerRepository;
import com.deliveryapp.delivery.customer.CustomerService;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CustomerController.class)
@Import(CustomerController.class)
public class CustomerControllerTest {

    @MockBean
    CustomerRepository repository;

    @MockBean
    CustomerService customerService;

    @Autowired
    private WebTestClient webClient;

    @Test
    public void shouldGetUser() {

        CustomerDto customerDto = createCustomerDto();

        when(customerService.getCustomer("1")).thenReturn(Mono.just(customerDto));

        webClient
                .get().uri("/api/customers")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(CustomerDto.class);
    }

    private CustomerDto createCustomerDto() {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId("1");
        customerDto.setFirstName("mehdi");
        customerDto.setLastName("bourras");
        customerDto.setEmail("elmehdi.bourras@gmail.com");

        return customerDto;
    }
}
