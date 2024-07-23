package com.deliveryapp.delivery.deliverymanagement;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/customersdelivery")
@AllArgsConstructor
public class CustomerDeliveryController {

    private CustomerDeliveryService customerDeliveryService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CustomerDeliveryDto> saveCustomerDelivery(@RequestBody CustomerDeliveryDto customerDeliveryDto){
        return customerDeliveryService.saveCustomerDelivery(customerDeliveryDto);
    }

    @GetMapping("{id}")
    public Mono<CustomerDeliveryDto> getCustomerDelivery(@PathVariable("id") String customerDeliveryId){
        return customerDeliveryService.getCustomerDelivery(customerDeliveryId);
    }

    @GetMapping
    public Flux<CustomerDeliveryDto> getAllCustomersDeliveries(){
        return customerDeliveryService.getAllCustomersDeliveries();
    }

    @PutMapping("{id}")
    public Mono<CustomerDeliveryDto> updateCustomerDelivery(@RequestBody CustomerDeliveryDto customerDeliveryDto,
                                            @PathVariable("id") String customerDeliveryId){
        return customerDeliveryService.updateCustomerDelivery(customerDeliveryDto, customerDeliveryId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCustomerDelivery(@PathVariable("id") String customerDeliveryId){
        return customerDeliveryService.deleteCustomerDelivery(customerDeliveryId);
    }
}
