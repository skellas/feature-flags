package com.sethkellas.featureflags.configurations;

import com.sethkellas.featureflags.properties.FeaturesAvailable;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FeaturesAvailable.class)
public class PropertiesConfiguration {
    
}
