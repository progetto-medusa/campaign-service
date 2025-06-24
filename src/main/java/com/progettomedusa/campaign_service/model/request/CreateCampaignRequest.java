package com.progettomedusa.campaign_service.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.UUID;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCampaignRequest {
    private Long id;
    @NotBlank
    @NotNull
    @NotEmpty
    private String name;
    @NotBlank
    @Size(min = 1, max = 500)
    private String description;
    @NotBlank
    private String ruleVersion;
    @NotNull
    private boolean bePrivate;
    private String password;
    @NotBlank
    @JsonProperty("applicationId")
    private String applicationId;
    private String updateTime;
    @NotBlank
    private String insertTime;
    private String creatorUuid;
}
