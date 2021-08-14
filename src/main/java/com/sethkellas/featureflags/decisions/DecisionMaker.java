package com.sethkellas.featureflags.decisions;

import static java.lang.String.format;

import java.util.List;

import com.sethkellas.featureflags.environments.Environment;
import com.sethkellas.featureflags.properties.FeaturesAvailable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecisionMaker {
    public static final String decisionFormat = "It is %ssafe to test on the %s.";

    @Autowired
    private Environment environment;

    @Autowired
    private FeaturesAvailable features;
    
    public List<String> availableFeatures() {
        return features.enabled();
    }
    
    public List<String> betaFeatures() {
        return features.disabled();
    }
    
    public String canWeTest() {
        return format(decisionFormat, safeToTestString(environment.safeToTest()), environment.getName());
    }

    public static String safeToTestString(Boolean safeToTest) {
        return safeToTest ? "" : "not ";
    }


    
}
