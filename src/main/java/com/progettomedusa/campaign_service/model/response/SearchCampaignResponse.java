package com.progettomedusa.campaign_service.model.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCampaignResponse extends RestResponse{
    private List<CampaignResponse> campaigns;
}
