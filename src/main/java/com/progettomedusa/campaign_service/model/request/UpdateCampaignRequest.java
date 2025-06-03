package com.progettomedusa.campaign_service.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCampaignRequest {
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
    @JsonProperty("application_id")
    private String applicationId;
}
