package com.egen.Weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                        .allowedHeaders("*");
            }
        };
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /*
    @Bean
    public NotificationMessagingTemplate getNotificationMessagingTemplate(AmazonSNS amazonSNS){
        return new NotificationMessagingTemplate(amazonSNS);
    }
     */
}
