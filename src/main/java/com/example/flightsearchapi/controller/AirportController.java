package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.model.request.AirportRequest;
import com.example.flightsearchapi.model.response.AirportResponse;
import com.example.flightsearchapi.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/airports")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

    @GetMapping
    public List<AirportResponse> getAirports() {
        return airportService.getAirports();
    }

    @GetMapping("/{id}")
    public AirportResponse getAirport(@PathVariable String id) {
        return airportService.getAirport(id);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AirportResponse createAirport(@RequestBody @Valid AirportRequest airportRequest) {
        return airportService.createAirport(airportRequest);
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AirportResponse updateAirport(@PathVariable String id, @RequestBody @Valid AirportRequest airportRequest) {
        return airportService.updateAirport(id, airportRequest);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteAirport(@PathVariable String id) {
        airportService.deleteAirport(id);
    }

}
