package com.deliveryapp.delivery.repository;

import com.deliveryapp.delivery.model.DeliveryMethod;
import com.deliveryapp.delivery.utils.DeliveryMethodEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class DeliveryMethodRepositoryTest {

    @Autowired
    private DeliveryMethodRepository repository;

    @Test
    public void when_one_DeliveryMethod_then_should_have_single_client() {

        // Given
        DeliveryMethod deliveryMethod = createDeliveryMethod();

        // When
        Publisher<DeliveryMethod> setup = repository.deleteAll().thenMany(repository.save(deliveryMethod));

        // Then
        StepVerifier
                .create(setup)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    public void should_save_DeliveryMethod(){

        // Given
        DeliveryMethod deliveryMethod = createDeliveryMethod();

        // When
        Publisher<DeliveryMethod> setup = repository.deleteAll().then(repository.save(deliveryMethod));
        Mono<DeliveryMethod> find  = repository.findById(deliveryMethod.getDeliveryMethodId());

        // Then
        Publisher<DeliveryMethod> composite = Mono
                .from(setup)
                .then(find);
        StepVerifier
                .create(composite)
                .consumeNextWith(DeliveryMethod1 -> {
                    assertNotNull(DeliveryMethod1.getDeliveryMethodId());
                    assertEquals(DeliveryMethod1.getDeliveryMethodName(), DeliveryMethodEnum.DELIVERY);
                })
                .verifyComplete();

    }

    private DeliveryMethod createDeliveryMethod() {

        DeliveryMethod deliveryMethod = new DeliveryMethod();
        deliveryMethod.setDeliveryMethodId("1");
        deliveryMethod.setDeliveryMethodName(DeliveryMethodEnum.DELIVERY);
        deliveryMethod.setStartTime(new Date());

        return deliveryMethod;
    }
}
