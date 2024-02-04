package com.example.flightsearchapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    private String id;
}
