# DeliveryApp

## Name
DeliveryApp

## Description

Delivery App is a simple reactive rest Api project that allows customers through exposed API's to
[] choose their delivery method
[] choose day and timeslot for their deliveries


## Run App
there are two ways to run the application
1- With Maven
2- With Docker

MAVEN : 

$ cd deliveryapp
$ mvn clean install
$ mvn spring-boot:run

DOCKER :

$ cd deliveryapp
$ docker-compose up -d

If something changed on the project run : 

$ cd bookdelivery
$ docker-compose up --build

## Documentation
you can explore Api documentation through swagger UI

http://localhost:8080/swagger-ui/

## Test and Deploy

In order to test the app, you should install http client like Postman and provide valid payload for each endpoint :

// To create a customer
// Due to lack of time, I did not implemented spring security in order to add a security layer

http://localhost:8080/api/customers

{
  "firstName": "mehdi",
  "lastName" : "bourras1",
  "email" : "elmehdi.bourras@gmail.com"
}

Delivery method

http://localhost:8080/api/deliverymethods

{
  "deliveryMethodId": "1",
  "deliveryMethodName" : "DELIVERY",
  "startTime" : "2024-09-15T00:00:00.000",
  "endTime" : "2024-09-15T17:00:00.000"
  
}

Assign a delivery to a customer with custom timeslot

http://localhost:8080/api/customersdelivery

{
  "customerId": "1",
  "deliveryMethodId" : "1",
  "dayOfWeek" : "MONDAY",
  "deliveryTime" : "00:00:00"

}


## Authors and acknowledgment
elmehdi bourras

## License
open source

