package com.deliveryapp.delivery.customer;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto){
        return customerService.saveCustomer(customerDto);
    }

    @GetMapping("{id}")
    public Mono<CustomerDto> getCustomer(@PathVariable("id") String customerId){
        return customerService.getCustomer(customerId);
    }

    @GetMapping
    public Flux<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PutMapping("{id}")
    public Mono<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto,
                                            @PathVariable("id") String customerId){
        return customerService.updateCustomer(customerDto, customerId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCustomer(@PathVariable("id") String customerId){
        return customerService.deleteCustomer(customerId);
    }
}
