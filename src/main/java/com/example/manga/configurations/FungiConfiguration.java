package com.example.manga.configurations;

import com.example.manga.models.BacteriaFactory;
import com.example.manga.models.FungiFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * todo Document type FungiConfiguration
 */
@Configuration
public class FungiConfiguration {
    @Bean
    public FungiFactory fungiFactory() {
        return new FungiFactory();
    }
}