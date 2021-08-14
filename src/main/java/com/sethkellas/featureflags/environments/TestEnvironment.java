package com.sethkellas.featureflags.environments;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test")
@Component
public class TestEnvironment implements Environment {
    public static final String NAME = "Test Environment";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean safeToTest() {
        return Boolean.TRUE;
    }
    
}
