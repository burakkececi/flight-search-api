package com.example.flightsearchapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flights")
@Getter
@Setter
public class Flight extends BaseEntity{

    private Airport departurePort;
    private Airport arrivalPort;
    private String departureDate;
    private String returnDate;
    private Integer price;
}
