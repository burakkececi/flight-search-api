package com.example.flightsearchapi.model.response;

import com.example.flightsearchapi.entity.Airport;
import com.example.flightsearchapi.entity.Flight;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightResponse {

    private String id;
    private Airport departurePort;
    private Airport arrivalPort;
    private String departureDate;
    private String returnDate;
    private Integer price;

    public static FlightResponse fromEntity(Flight flight) {
        return FlightResponse.builder()
                .id(flight.getId())
                .departurePort(flight.getDeparturePort())
                .arrivalPort(flight.getArrivalPort())
                .departureDate(flight.getDepartureDate())
                .returnDate(flight.getReturnDate())
                .price(flight.getPrice())
                .build();
    }
}
