package com.progettomedusa.campaign_service.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCampaignRequest {
    @NotBlank
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Size(min = 1, max = 500)
    private String description;
    @NotBlank
    private String ruleVersion;
    @NotNull
    private boolean bePrivate;
    @NotBlank
    @Size(min = 8, max = 24)
    private String password;
    @NotNull
    @JsonProperty("application_id")
    private String applicationId;
}
