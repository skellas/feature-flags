package com.sethkellas.featureflags.environments;

public interface Environment {
    String getName();

    default Boolean safeToTest() {
        return Boolean.FALSE;
    }
    
}
