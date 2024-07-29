package com.deliveryapp.delivery.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@ApiModel("Customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("customers")
public class Customer {

    @Id
    private String customerId;

    private String firstName;

    private String lastName;

    private String email;

}
