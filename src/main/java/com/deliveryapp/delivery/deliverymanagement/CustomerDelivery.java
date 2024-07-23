package com.deliveryapp.delivery.deliverymanagement;

import com.deliveryapp.delivery.customer.Customer;
import com.deliveryapp.delivery.delivery.DeliveryMethod;
import com.deliveryapp.delivery.utils.TimeSlot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DayOfWeek;
import java.time.LocalTime;

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
