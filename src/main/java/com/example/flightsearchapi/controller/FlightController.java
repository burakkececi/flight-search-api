package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.model.request.FlightRequest;
import com.example.flightsearchapi.model.response.FlightResponse;
import com.example.flightsearchapi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public List<FlightResponse> getFlights() {
        return flightService.getFlights();
    }

    @GetMapping("/{id}")
    public FlightResponse getFlight(@PathVariable String id) {
        return flightService.getFlight(id);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public FlightResponse createFlight(@RequestBody @Valid FlightRequest flightRequest) {
        return flightService.createFlight(flightRequest);
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public FlightResponse updateFlight(@PathVariable String id, @RequestBody @Valid FlightRequest flightRequest) {
        return flightService.updateFlight(id, flightRequest);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteFlight(@PathVariable String id) {
        flightService.deleteFlight(id);
    }
}
