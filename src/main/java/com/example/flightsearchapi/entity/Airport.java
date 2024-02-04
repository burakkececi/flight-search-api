package com.example.flightsearchapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "airports")
@Getter
@Setter
public class Airport extends BaseEntity {

    private String port;
}
