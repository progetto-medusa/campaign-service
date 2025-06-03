package com.progettomedusa.campaign_service.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequestResponse extends RestResponse {
    private String id;
    private String name;
    private String description;
    private String ruleVersion;
    private String applicationId;
    private Error error;
}
