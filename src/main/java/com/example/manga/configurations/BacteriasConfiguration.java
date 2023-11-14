package com.example.manga.configurations;

import com.example.manga.models.BacteriaFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BacteriasConfiguration {
    @Bean
    public BacteriaFactory bacteriaFactory() {
        return new BacteriaFactory();
    }
}
