package com.deliveryapp.delivery.controller;


import com.deliveryapp.delivery.dto.DeliveryMethodDto;
import com.deliveryapp.delivery.service.DeliveryMethodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Api("Delivery Methods CRUD API")
@RestController
@RequestMapping("api/deliverymethods")
@AllArgsConstructor
public class DeliveryMethodController {

    private DeliveryMethodService deliveryMethodService;

    @ApiOperation("Creates a Delivery Method")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<DeliveryMethodDto> saveDeliveryMethod(@RequestBody DeliveryMethodDto DeliveryMethodDto){
        return deliveryMethodService.saveDeliveryMethod(DeliveryMethodDto);
    }

    @ApiOperation("Get Delivery Method by id")
    @GetMapping("{id}")
    public Mono<DeliveryMethodDto> getDeliveryMethod(@PathVariable("id") String deliveryMethodId){
        return deliveryMethodService.getDeliveryMethod(deliveryMethodId);
    }

    @ApiOperation("Get all delivery methods")
    @GetMapping
    public Flux<DeliveryMethodDto> getAllDeliveryMethods(){
        return deliveryMethodService.getAllDeliveryMethods();
    }

    @ApiOperation("Delete Delivery Method by id")
    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCustomer(@PathVariable("id") String deliveryMethodId){
        return deliveryMethodService.deleteDeliveryMethod(deliveryMethodId);
    }
}
