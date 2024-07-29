package com.deliveryapp.delivery.controller;


import com.deliveryapp.delivery.dto.CustomerDeliveryDto;
import com.deliveryapp.delivery.service.CustomerDeliveryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Api("Customer Delivery Association CRUD API")
@RestController
@RequestMapping("api/customersdelivery")
@AllArgsConstructor
public class CustomerDeliveryController {

    private CustomerDeliveryService customerDeliveryService;


    @ApiOperation("Creates a customer delivery, association between customer and delivery")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CustomerDeliveryDto> saveCustomerDelivery(@RequestBody CustomerDeliveryDto customerDeliveryDto){
        return customerDeliveryService.saveCustomerDelivery(customerDeliveryDto);
    }

    @ApiOperation("Get a customer deliver by id")
    @GetMapping("{id}")
    public Mono<CustomerDeliveryDto> getCustomerDelivery(@PathVariable("id") String customerDeliveryId){
        return customerDeliveryService.getCustomerDelivery(customerDeliveryId);
    }

    @ApiOperation("Get all customer deliveriesr")
    @GetMapping
    public Flux<CustomerDeliveryDto> getAllCustomersDeliveries(){
        return customerDeliveryService.getAllCustomersDeliveries();
    }

    @ApiOperation("Update customer delivery")
    @PutMapping("{id}")
    public Mono<CustomerDeliveryDto> updateCustomerDelivery(@RequestBody CustomerDeliveryDto customerDeliveryDto,
                                            @PathVariable("id") String customerDeliveryId){
        return customerDeliveryService.updateCustomerDelivery(customerDeliveryDto, customerDeliveryId);
    }

    @ApiOperation("Delete a customer delivery by id")
    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCustomerDelivery(@PathVariable("id") String customerDeliveryId){
        return customerDeliveryService.deleteCustomerDelivery(customerDeliveryId);
    }
}
