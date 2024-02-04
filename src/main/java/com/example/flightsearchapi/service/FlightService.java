package com.example.flightsearchapi.service;

import com.example.flightsearchapi.entity.Airport;
import com.example.flightsearchapi.entity.Flight;
import com.example.flightsearchapi.model.request.FlightRequest;
import com.example.flightsearchapi.model.response.FlightResponse;
import com.example.flightsearchapi.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FlightService {
    private final FlightRepository flightRepository;

    public List<FlightResponse> getFlights() {
        return flightRepository.findAll().stream().map(FlightResponse::fromEntity).collect(Collectors.toList());
    }

    public FlightResponse getFlight(String id) {
        return FlightResponse.fromEntity(flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Error")));
    }

    public FlightResponse createFlight(FlightRequest flightRequest) {
        Flight flight = setNewFlight(flightRequest);
        flightRepository.save(flight);
        return FlightResponse.fromEntity(flight);
    }

    public FlightResponse updateFlight(String id, FlightRequest flightRequest) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Error"));
        flight.setDeparturePort(flightRequest.getDeparturePort());
        flight.setArrivalPort(flightRequest.getArrivalPort());
        flight.setDepartureDate(flightRequest.getDepartureDate());
        flight.setReturnDate(flightRequest.getReturnDate());
        flight.setPrice(flightRequest.getPrice());
        flightRepository.save(flight);
        return FlightResponse.fromEntity(flight);
    }

    public void deleteFlight(String id) {
        flightRepository.deleteById(id);
    }

    public List<FlightResponse> searchOneWayFlights(FlightRequest flightRequest) {
        return flightRepository.findOneWayFlights(flightRequest.getDeparturePort(), flightRequest.getArrivalPort(), flightRequest.getDepartureDate()).stream().map(FlightResponse::fromEntity).collect(Collectors.toList());
    }

    public List<FlightResponse> searchRoundTripFlight(FlightRequest flightRequest) {
        return flightRepository.findRoundTripFlights(flightRequest.getDeparturePort(), flightRequest.getArrivalPort(), flightRequest.getDepartureDate(), flightRequest.getReturnDate()).stream().map(FlightResponse::fromEntity).collect(Collectors.toList());
    }

    @Scheduled(cron = "@daily")
    public void fetchFlightsFromExternalAPI() {
        // get flights from external API
        FlightRequest flightRequest = new FlightRequest();
        Airport departurePort = new Airport();
        departurePort.setPort("IST");
        flightRequest.setDeparturePort(departurePort);
        flightRequest.setDepartureDate("2022-12-01");
        flightRequest.setReturnDate("2022-12-02");
        flightRequest.setPrice(100);
        List<FlightRequest> flights = List.of(flightRequest);
        flightRepository.saveAll(flights.stream().map(this::setNewFlight).collect(Collectors.toList()));
    }

    private Flight setNewFlight(FlightRequest flightRequest) {
        Flight flight = new Flight();
        flight.setId(UUID.randomUUID().toString());
        flight.setDeparturePort(flightRequest.getDeparturePort());
        flight.setArrivalPort(flightRequest.getArrivalPort());
        flight.setDepartureDate(flightRequest.getDepartureDate());
        flight.setReturnDate(flightRequest.getReturnDate());
        flight.setPrice(flightRequest.getPrice());
        return flight;
    }
}
