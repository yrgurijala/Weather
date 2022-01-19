package com.egen.Weather.controller;

import com.egen.Weather.model.Weather;
import com.egen.Weather.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    WeatherService weatherService;

    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("/mySimpleGet")
    public String mySimpleGetMethod(){
        return "My Simple Get String";
    }

    @PostMapping("/addData")
    public boolean addData(@RequestBody Weather weather) throws JsonProcessingException {
        weatherService.addWeatherReading(weather);
        return true;
    }

    @GetMapping("/getDataSortedByCity")
    public List<Weather> getDataSortedByCity(){
        return weatherService.getWeatherReadingsSorted();
    }
}
