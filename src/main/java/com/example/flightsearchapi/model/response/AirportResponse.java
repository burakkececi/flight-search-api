package com.example.flightsearchapi.model.response;

import com.example.flightsearchapi.entity.Airport;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AirportResponse {

    private String id;
    private String port;

    public static AirportResponse fromEntity(Airport airport) {
        return AirportResponse.builder()
                .id(airport.getId())
                .port(airport.getPort())
                .build();
    }
}
