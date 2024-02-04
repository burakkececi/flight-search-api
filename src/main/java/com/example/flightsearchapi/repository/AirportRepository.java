package com.example.flightsearchapi.repository;

import com.example.flightsearchapi.entity.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AirportRepository extends MongoRepository<Airport, String> {
}
