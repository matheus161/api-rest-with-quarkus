package com.matheus161;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @RestClient
    StarWarsService starWarsService;

    @Override
    public HealthCheckResponse call() {
        if (starWarsService.getStarships().contains(StarWarsService.MSG_ERROR)) {
            return HealthCheckResponse.down("I'm NOT ready");
        }

        return HealthCheckResponse.up("I'm ready");
    }
}
