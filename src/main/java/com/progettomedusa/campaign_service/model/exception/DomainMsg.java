package com.progettomedusa.campaign_service.model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DomainMsg {
    CAMPAIGN_SERVICE_TECHNICAL("CampaignServiceTechnicals"),
    MICROSERVICE_FUNCTIONAL("MicroServiceFunctional");

    private final String name;
}
