package com.deliveryapp.delivery.customer;


import com.deliveryapp.delivery.delivery.DeliveryMethod;
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
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Mono<Customer> savedCustomer = customerRepository.save(customer);
        return savedCustomer
                .map(CustomerMapper::mapToCustomerDto);
    }

    @Override
    public Mono<CustomerDto> getCustomer(String customerId) {
        Mono<Customer> customerMono = customerRepository.findById(customerId);
        return customerMono.map((CustomerMapper::mapToCustomerDto));
    }

    @Override
    public Flux<CustomerDto> getAllCustomers() {
        Flux<Customer> customerFlux = customerRepository.findAll();
        return customerFlux
                .map(CustomerMapper::mapToCustomerDto)
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
        }).map((CustomerMapper::mapToCustomerDto));
    }

    @Override
    public Mono<Void> deleteCustomer(String customerId) {
        return customerRepository.deleteById(customerId);
    }
}
