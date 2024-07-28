package com.deliveryapp.delivery.controller;

import com.deliveryapp.delivery.dto.DeliveryMethodDto;
import com.deliveryapp.delivery.service.DeliveryMethodService;
import com.deliveryapp.delivery.utils.DeliveryMethodEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Date;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = DeliveryMethodController.class)
@Import(DeliveryMethodController.class)
public class DeliveryMethodControllerTest {
    

    @MockBean
    DeliveryMethodService deliveryMethodService;

    @Autowired
    private WebTestClient webClient;

    @Test
    public void shouldGetUser() {

        DeliveryMethodDto deliveryMethodDto = createDeliveryMethodDto();

        when(deliveryMethodService.getDeliveryMethod("1")).thenReturn(Mono.just(deliveryMethodDto));

        webClient
                .get().uri("/api/deliverymethods")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(DeliveryMethodDto.class);
    }

    private DeliveryMethodDto createDeliveryMethodDto() {

        DeliveryMethodDto deliveryMethodDto = new DeliveryMethodDto();
        deliveryMethodDto.setDeliveryMethodId("1");
        deliveryMethodDto.setDeliveryMethodName(DeliveryMethodEnum.DELIVERY);
        deliveryMethodDto.setStartTime(new Date());

        return deliveryMethodDto;
    }
}
