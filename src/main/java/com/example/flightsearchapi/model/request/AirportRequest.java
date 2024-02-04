package com.example.flightsearchapi.model.request;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AirportRequest {

    @NotEmpty
    private String port;
}
