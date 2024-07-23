package com.deliveryapp.delivery.delivery;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeliveryMethodServiceImpl implements DeliveryMethodService {

    private DeliveryMethodRepository deliveryMethodRepository;

    @Override
    public Mono<DeliveryMethodDto> saveDeliveryMethod(DeliveryMethodDto DeliveryMethodDto) {
        DeliveryMethod deliveryMethod = DeliveryMethodMapper.mapToDeliveryMethod(DeliveryMethodDto);
        Mono<DeliveryMethod> saveddeliveryMethod = deliveryMethodRepository.save(deliveryMethod);
        return saveddeliveryMethod
                .map(DeliveryMethodMapper::mapToDeliveryMethodDto);
    }

    @Override
    public Mono<DeliveryMethodDto> getDeliveryMethod(String deliveryMethodId) {
        Mono<DeliveryMethod> deliveryMethodMono = deliveryMethodRepository.findById(deliveryMethodId);
        return deliveryMethodMono.map((DeliveryMethodMapper::mapToDeliveryMethodDto));
    }

    @Override
    public Flux<DeliveryMethodDto> getAllDeliveryMethods() {
        Flux<DeliveryMethod> deliveryMethodFlux = deliveryMethodRepository.findAll();
        return deliveryMethodFlux
                .map(DeliveryMethodMapper::mapToDeliveryMethodDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Void> deleteDeliveryMethod(String deliveryMethodId) {
        return deliveryMethodRepository.deleteById(deliveryMethodId);
    }
}
