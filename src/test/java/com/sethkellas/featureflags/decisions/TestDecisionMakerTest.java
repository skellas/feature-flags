package com.sethkellas.featureflags.decisions;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.sethkellas.featureflags.environments.TestEnvironment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDecisionMakerTest {
    
	@Autowired
	private DecisionMaker decisionMaker;
    
	@Test
	void shouldDefaultToTestEnvironment() {
		String decision = decisionMaker.canWeTest();

		assertThat(decision).as("Should describe the Test environment.")
			.isEqualTo(format(DecisionMaker.decisionFormat,
				DecisionMaker.safeToTestString(Boolean.TRUE),
				TestEnvironment.NAME));
	}

	@Test
	void shouldReturnAvailableFeatures() {
		List<String> availableFeatures = decisionMaker.availableFeatures();

		assertThat(availableFeatures).containsExactly("Feature One", "Feature Two");
	}
	
	@Test
	void shouldReturnADisabledFeatures() {
		List<String> availableFeatures = decisionMaker.betaFeatures();

		assertThat(availableFeatures).containsExactly("Beta Feature");
	}
}
