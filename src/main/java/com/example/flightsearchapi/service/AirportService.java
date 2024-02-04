package com.example.flightsearchapi.service;


import com.example.flightsearchapi.entity.Airport;
import com.example.flightsearchapi.model.request.AirportRequest;
import com.example.flightsearchapi.model.response.AirportResponse;
import com.example.flightsearchapi.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;

    public List<AirportResponse> getAirports() {
        return airportRepository.findAll().stream().map(AirportResponse::fromEntity).collect(Collectors.toList());
    }

    public AirportResponse getAirport(String id) {
        return AirportResponse.fromEntity(airportRepository.findById(id).orElseThrow(() -> new RuntimeException("Error")));
    }

    public AirportResponse createAirport(AirportRequest airportRequest) {
        Airport airport = new Airport();
        airport.setId(UUID.randomUUID().toString());
        airport.setPort(airportRequest.getPort());
        airportRepository.save(airport);
        return AirportResponse.fromEntity(airport);
    }

    public AirportResponse updateAirport(String id, AirportRequest airportRequest) {
        Airport airport = airportRepository.findById(id).orElseThrow(() -> new RuntimeException("Error"));
        airport.setPort(airportRequest.getPort());
        airportRepository.save(airport);
        return AirportResponse.fromEntity(airport);
    }

    public void deleteAirport(String id) {
        airportRepository.deleteById(id);
    }
}
