package com.deliveryapp.delivery.service;


import com.deliveryapp.delivery.dto.CustomerDto;
import com.deliveryapp.delivery.exception.ResourceNotFoundException;
import com.deliveryapp.delivery.mappers.CustomerMapper;
import com.deliveryapp.delivery.model.Customer;
import com.deliveryapp.delivery.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements  CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public Mono<CustomerDto> saveCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.INSTANCE.mapDtoToCustomer(customerDto);
        Mono<Customer> savedCustomer = customerRepository.save(customer);
        return savedCustomer
                .map(CustomerMapper.INSTANCE::mapCustomerToDto);
    }

    @Override
    public Mono<CustomerDto> getCustomer(String customerId) {
        Mono<Customer> customerMono = customerRepository.findById(customerId);
        return customerMono
                .flatMap(customer -> customerMono.map((CustomerMapper.INSTANCE::mapCustomerToDto)))
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Resource not found with id: " + customerId)));
    }

    @Override
    public Flux<CustomerDto> getAllCustomers() {
        Flux<Customer> customerFlux = customerRepository.findAll();
        return customerFlux
                .map(CustomerMapper.INSTANCE::mapCustomerToDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<CustomerDto> updateCustomer(CustomerDto customerDto, String customerId) {

        Mono<Customer> customerMono = customerRepository.findById(customerId);

        return customerMono.flatMap((existingCustomer) -> {
            existingCustomer.setFirstName(customerDto.getFirstName());
            existingCustomer.setLastName(customerDto.getLastName());
            existingCustomer.setEmail(customerDto.getEmail());
            return customerRepository.save(existingCustomer);
        }).map((CustomerMapper.INSTANCE::mapCustomerToDto));
    }

    @Override
    public Mono<Void> deleteCustomer(String customerId) {
        return customerRepository.deleteById(customerId);
    }
}
