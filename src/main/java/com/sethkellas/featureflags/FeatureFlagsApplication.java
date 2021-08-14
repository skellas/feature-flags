package com.sethkellas.featureflags;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class FeatureFlagsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeatureFlagsApplication.class, args);
	}

}
