package com.progettomedusa.campaign_service.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CampaignSearchDTO {
    private String startDate;
    private String campaignName;
    private String creatorUuid;
    private String limit;
}