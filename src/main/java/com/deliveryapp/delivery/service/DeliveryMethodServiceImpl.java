package com.deliveryapp.delivery.service;


import com.deliveryapp.delivery.dto.DeliveryMethodDto;
import com.deliveryapp.delivery.exception.ResourceNotFoundException;
import com.deliveryapp.delivery.mappers.DeliveryMethodMapper;
import com.deliveryapp.delivery.model.DeliveryMethod;
import com.deliveryapp.delivery.repository.DeliveryMethodRepository;
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
        DeliveryMethod deliveryMethod = DeliveryMethodMapper.INSTANCE.mapDtoToDeliveryMethod(DeliveryMethodDto);
        Mono<DeliveryMethod> saveddeliveryMethod = deliveryMethodRepository.save(deliveryMethod);
        return saveddeliveryMethod
                .map(DeliveryMethodMapper.INSTANCE::mapDeliveryMethodToDto);
    }

    @Override
    public Mono<DeliveryMethodDto> getDeliveryMethod(String deliveryMethodId) {

        Mono<DeliveryMethod> deliveryMethodMono = deliveryMethodRepository.findById(deliveryMethodId);

        return deliveryMethodMono
                .flatMap(deliveryMethod -> deliveryMethodMono.map((DeliveryMethodMapper.INSTANCE::mapDeliveryMethodToDto)))
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Delivery Method not found with id: " + deliveryMethodId)));
    }

    @Override
    public Flux<DeliveryMethodDto> getAllDeliveryMethods() {
        Flux<DeliveryMethod> deliveryMethodFlux = deliveryMethodRepository.findAll();
        return deliveryMethodFlux
                .map(DeliveryMethodMapper.INSTANCE::mapDeliveryMethodToDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Void> deleteDeliveryMethod(String deliveryMethodId) {
        return deliveryMethodRepository.deleteById(deliveryMethodId);
    }
}
