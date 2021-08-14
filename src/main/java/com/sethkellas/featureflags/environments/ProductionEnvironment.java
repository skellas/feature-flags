package com.sethkellas.featureflags.environments;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("production")
@Component
public class ProductionEnvironment implements Environment {
    public static final String NAME = "Production Environment";

    @Override
    public String getName() {
        return NAME;
    }

}
