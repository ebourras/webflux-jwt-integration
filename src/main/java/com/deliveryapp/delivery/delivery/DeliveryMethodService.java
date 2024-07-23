package com.deliveryapp.delivery.delivery;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DeliveryMethodService {

    Mono<DeliveryMethodDto> saveDeliveryMethod(@RequestBody DeliveryMethodDto DeliveryMethodDto);

    Mono<DeliveryMethodDto> getDeliveryMethod(@PathVariable("id") String deliveryMethodId);

    public Flux<DeliveryMethodDto> getAllDeliveryMethods();

    Mono<Void> deleteDeliveryMethod(@PathVariable("id") String deliveryMethodId);

}
