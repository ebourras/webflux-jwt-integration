package com.deliveryapp.delivery.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DayOfWeek;
import java.time.LocalTime;

@ApiModel("Customer Delivery Association ")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("customerdeliveries")
public class CustomerDelivery {

    @Id
    private String id;
    private String customerId;
    private String deliveryMethodId;
    private DayOfWeek dayOfWeek;
    private LocalTime deliveryTime;


}
