package com.sethkellas.featureflags.decisions;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.sethkellas.featureflags.environments.DevelopmentEnvironment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("development")
public class DevelopmentDecisionMakerTest {
    
	@Autowired
	private DecisionMaker decisionMaker;
    
	@Test
	void shouldUseDevelopmentEnvironment() {
		String decision = decisionMaker.canWeTest();

		assertThat(decision).as("Should describe the Development environment.")
			.isEqualTo(format(DecisionMaker.decisionFormat,
				DecisionMaker.safeToTestString(Boolean.TRUE),
				DevelopmentEnvironment.NAME));
	}
	
	@Test
	void shouldReturnAvailableFeatures() {
		List<String> availableFeatures = decisionMaker.availableFeatures();

		assertThat(availableFeatures).containsExactly("Feature One");
	}
	
	@Test
	void shouldReturnADisabledFeatures() {
		List<String> availableFeatures = decisionMaker.betaFeatures();

		assertThat(availableFeatures).containsExactly("Feature Two", "Beta Feature");
	}
}
