package com.example.flightsearchapi.repository;

import com.example.flightsearchapi.entity.Airport;
import com.example.flightsearchapi.entity.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FlightRepository extends MongoRepository<Flight, String> {

    @Query(value = "{'departurePort': ?0, 'arrivalPort': ?1, 'departureDate': ?2}")
    List<Flight> findOneWayFlights(Airport departurePort, Airport arrivalPort, String departureDate);

    @Query(value = "{'departurePort': ?0, 'arrivalPort': ?1, 'departureDate': ?2, 'returnDate': ?3}")
    List<Flight> findRoundTripFlights(Airport departurePort, Airport arrivalPort, String departureDate, String returnDate);
}
