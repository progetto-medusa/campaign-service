package com.progettomedusa.campaign_service.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestResponse {
    @JsonProperty("message")
    @Size(max = 2048)
    private String message;

    @JsonProperty
    @Size(max = 64)
    private String domain;

    @JsonProperty("detailed")
    @Size(max = 4096)
    private String detailed;

    @JsonProperty("timestamp")
    @Size(max = 1024)
    private String timestamp;

}
