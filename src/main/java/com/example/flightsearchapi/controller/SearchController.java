package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.model.request.FlightRequest;
import com.example.flightsearchapi.model.response.FlightResponse;
import com.example.flightsearchapi.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping
    public List<FlightResponse> search(@RequestBody @Valid FlightRequest flightRequest) {
        // if returnDate is null, then it is a one way trip
        if (flightRequest.getReturnDate() == null) {
            return searchService.searchOneWayFlight(flightRequest);
        } else {
            return searchService.searchRoundTripFlight(flightRequest);
        }
    }
}
