package com.sethkellas.featureflags.properties;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("features")
public record FeaturesAvailable( List<String> enabled, List<String> disabled) {
    @ConstructorBinding
    public FeaturesAvailable(List<String> enabled, List<String> disabled) {
        this.enabled = Optional.ofNullable(enabled).orElse(Collections.emptyList());
        this.disabled = Optional.ofNullable(disabled).orElse(Collections.emptyList());
    }
}
