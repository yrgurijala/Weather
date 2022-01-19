package com.egen.Weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
public class WeatherAlert {

    private String alertStatus;
    private Weather weather;
}
