package com.example.flightsearchapi.model.request;

import com.example.flightsearchapi.entity.Airport;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;

@Data
public class FlightRequest {
    @Id
    private String id;

    @NotEmpty
    private Airport departurePort;

    @NotEmpty
    private Airport arrivalPort;

    @NotEmpty
    private String departureDate;

    private String returnDate;

    @NotEmpty
    private Integer price;
}
