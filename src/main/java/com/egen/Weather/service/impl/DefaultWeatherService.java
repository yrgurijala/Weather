package com.egen.Weather.service.impl;

import com.egen.Weather.model.Weather;
import com.egen.Weather.model.WeatherAlert;
import com.egen.Weather.repo.WeatherRepository;
import com.egen.Weather.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;

@Service
public class DefaultWeatherService implements WeatherService {
    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;
    //private final WeatherAlertSns weatherAlertSns;
    //private final ObjectMapper objectMapper;

    public DefaultWeatherService(WeatherRepository weatherRepository,
                                 RestTemplate restTemplate
                                 //WeatherAlertSns weatherAlertSns,
                                 //ObjectMapper objectMapper
                                 ){
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
        //this.weatherAlertSns = weatherAlertSns;
        //this.objectMapper = objectMapper;
    }

    @Override
    public boolean addWeatherReading(Weather weather) throws JsonProcessingException {
        System.out.println(weather);
        weatherRepository.save(weather);

        if(weather.getTemperature() > 25){
            WeatherAlert weatherAlert = new WeatherAlert("Its too Hot", weather);
            restTemplate.postForObject("http://localhost:8081/weatherAlert/addData", weatherAlert, boolean.class);
            //weatherAlertSns.send("Temeparature Alert", objectMapper.writeValueAsString(weatherAlert));
        }

        if(weather.getWind().getSpeed() > 6){
            WeatherAlert weatherAlert = new WeatherAlert("Its too windy", weather);
            restTemplate.postForObject("http://localhost:8081/weatherAlert/addData", weatherAlert, boolean.class);
            //weatherAlertSns.send("Wind Alert", objectMapper.writeValueAsString(weather));
        }

        return true;
    }

    @Override
    public List<Weather> getWeatherReadingsSorted() {
        List<Weather> weatherList = weatherRepository.findAll();
        weatherList.sort(Comparator.comparing(Weather::getCity));
        return weatherList;
    }
}
