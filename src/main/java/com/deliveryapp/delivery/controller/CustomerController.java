package com.deliveryapp.delivery.controller;


import com.deliveryapp.delivery.dto.CustomerDto;
import com.deliveryapp.delivery.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Api("Customer CRUD API")
@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;


    @ApiOperation("Create a basic customer")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto){
        return customerService.saveCustomer(customerDto);
    }

    @ApiOperation("Get Customer By Id")
    @GetMapping("{id}")
    public Mono<CustomerDto> getCustomer(@PathVariable("id") String customerId){
        return customerService.getCustomer(customerId);
    }

    @ApiOperation("Returns all customers")
    @GetMapping
    public Flux<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @ApiOperation("Update customer")
    @PutMapping("{id}")
    public Mono<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto,
                                            @PathVariable("id") String customerId){
        return customerService.updateCustomer(customerDto, customerId);
    }

    @ApiOperation("Delete customer by id")
    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCustomer(@PathVariable("id") String customerId){
        return customerService.deleteCustomer(customerId);
    }
}
