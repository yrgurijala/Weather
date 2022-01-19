package com.egen.Weather.service;

import com.egen.Weather.model.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface WeatherService {

    boolean addWeatherReading(Weather weather) throws JsonProcessingException;
    List<Weather> getWeatherReadingsSorted();
}
