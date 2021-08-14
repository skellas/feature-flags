package com.sethkellas.featureflags.environments;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("development")
@Component
public class DevelopmentEnvironment implements Environment {
    public static final String NAME = "Development Environment";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean safeToTest() {
        return Boolean.TRUE;
    }
    
}
