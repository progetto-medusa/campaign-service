package com.progettomedusa.campaign_service.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonProperty("rule_version")
    private String ruleVersion;
    @NotNull
    @JsonProperty("be_private")
    private boolean bePrivate;
    private String password;
    @NotBlank
    @JsonProperty("application_id")
    private String applicationId;

    private String creatorUuid;
}
