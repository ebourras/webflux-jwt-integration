package com.deliveryapp.delivery.service;

import com.deliveryapp.delivery.dto.CustomerDeliveryDto;
import com.deliveryapp.delivery.model.Customer;
import com.deliveryapp.delivery.repository.CustomerRepository;
import com.deliveryapp.delivery.model.CustomerDelivery;
import com.deliveryapp.delivery.repository.CustomerDeliveryRepository;
import com.deliveryapp.delivery.mappers.CustomerDeliveryMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class CustomerDeliveryServiceImpl implements  CustomerDeliveryService{

    @Autowired
    private CustomerDeliveryRepository customerDeliveryRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Mono<CustomerDeliveryDto> saveCustomerDelivery(CustomerDeliveryDto customerDeliveryDto) {

        CustomerDelivery customerDelivery = CustomerDeliveryMapper.INSTANCE.mapDtoToCustomerDelivery(customerDeliveryDto);
        Mono<CustomerDelivery> savedCustomerDelivery = customerDeliveryRepository.save(customerDelivery);
        return savedCustomerDelivery.map(CustomerDeliveryMapper.INSTANCE::mapCustomerDeliveryToDto);

    }

    @Override
    public Mono<CustomerDeliveryDto> getCustomerDelivery(String customerId) {
        Mono<CustomerDelivery> customerDeliveryMono = customerDeliveryRepository.findById(customerId);
        return customerDeliveryMono.map((CustomerDeliveryMapper.INSTANCE::mapCustomerDeliveryToDto));
    }

    @Override
    public Flux<CustomerDeliveryDto> getAllCustomersDeliveries() {
        Flux<CustomerDelivery> customerDeliveryFlux = customerDeliveryRepository.findAll();
        return customerDeliveryFlux
                .map(CustomerDeliveryMapper.INSTANCE::mapCustomerDeliveryToDto)
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
