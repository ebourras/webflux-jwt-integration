package com.deliveryapp.delivery.delivery;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/deliverymethods")
@AllArgsConstructor
public class DeliveryMethodController {

    private DeliveryMethodService deliveryMethodService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<DeliveryMethodDto> saveDeliveryMethod(@RequestBody DeliveryMethodDto DeliveryMethodDto){
        return deliveryMethodService.saveDeliveryMethod(DeliveryMethodDto);
    }

    @GetMapping("{id}")
    public Mono<DeliveryMethodDto> getDeliveryMethod(@PathVariable("id") String deliveryMethodId){
        return deliveryMethodService.getDeliveryMethod(deliveryMethodId);
    }

    @GetMapping
    public Flux<DeliveryMethodDto> getAllDeliveryMethods(){
        return deliveryMethodService.getAllDeliveryMethods();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCustomer(@PathVariable("id") String deliveryMethodId){
        return deliveryMethodService.deleteDeliveryMethod(deliveryMethodId);
    }
}
