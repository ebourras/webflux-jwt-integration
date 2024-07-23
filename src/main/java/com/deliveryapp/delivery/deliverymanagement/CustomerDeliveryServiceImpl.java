package com.deliveryapp.delivery.deliverymanagement;

import com.deliveryapp.delivery.customer.Customer;
import com.deliveryapp.delivery.customer.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.servlet.function.ServerResponse.ok;


@Service
@AllArgsConstructor
public class CustomerDeliveryServiceImpl implements  CustomerDeliveryService{

    @Autowired
    private CustomerDeliveryRepository customerDeliveryRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Mono<CustomerDeliveryDto> saveCustomerDelivery(CustomerDeliveryDto customerDeliveryDto) {

        CustomerDelivery customerDelivery = CustomerDeliveryMapper.mapToCustomerDelivery(customerDeliveryDto);
        Mono<CustomerDelivery> savecCustomerDelivery = customerDeliveryRepository.save(customerDelivery);
        return savecCustomerDelivery.map(CustomerDeliveryMapper::mapToCustomerDeliveryDto);

    }

    @Override
    public Mono<CustomerDeliveryDto> getCustomerDelivery(String customerId) {
        Mono<CustomerDelivery> customerDeliveryMono = customerDeliveryRepository.findById(customerId);
        return customerDeliveryMono.map((CustomerDeliveryMapper::mapToCustomerDeliveryDto));
    }

    @Override
    public Flux<CustomerDeliveryDto> getAllCustomersDeliveries() {
        Flux<CustomerDelivery> customerDeliveryFlux = customerDeliveryRepository.findAll();
        return customerDeliveryFlux
                .map(CustomerDeliveryMapper::mapToCustomerDeliveryDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<CustomerDeliveryDto> updateCustomerDelivery(CustomerDeliveryDto customerDeliveryDto, String customerId) {
        return null;
    }

    @Override
    public Mono<Void> deleteCustomerDelivery(String customerId) {
        return null;
    }


    private String validateDelivery(CustomerDeliveryDto customerDeliveryDto) {

        String errorMessage = "";
        String customerId = customerDeliveryDto.getCustomerId();
        if(customerId == null || customerId.isEmpty()){
            errorMessage = "Customer Id is not valid";
        }

        Mono<Customer> customer = customerRepository.findById(customerId);
        if(customer.blockOptional().isEmpty()){
            errorMessage = "customer does not exist";
        }

        return errorMessage;
    }

}
