package com.deliveryapp.delivery.model;

import com.deliveryapp.delivery.utils.DeliveryMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("deliverymethods")
public class DeliveryMethod {

    @Id
    private String deliveryMethodId;

    private DeliveryMethodEnum deliveryMethodName;

    private Date startTime;

    private Date endTime;
}
