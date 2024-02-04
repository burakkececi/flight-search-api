package com.example.flightsearchapi.service;

import com.example.flightsearchapi.model.request.FlightRequest;
import com.example.flightsearchapi.model.response.FlightResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private FlightService flightService;

    public List<FlightResponse> searchOneWayFlight(FlightRequest flightRequest) {
        return flightService.searchOneWayFlights(flightRequest);
    }

    public List<FlightResponse> searchRoundTripFlight(FlightRequest flightRequest) {
        return flightService.searchRoundTripFlight(flightRequest);
    }
}
