package com.progettomedusa.campaign_service.model.converter;

import org.springframework.stereotype.Component;
import com.progettomedusa.campaign_service.dto.CampaignDTO;
import com.progettomedusa.campaign_service.model.po.CampaignPO;

@Component
public class CampaignConverter {

    public CampaignDTO campaignDTO(CampaignPO campaignPO) {
        if (campaignPO == null) return null;
        return new CampaignDTO(
                campaignPO.getName(),
                campaignPO.getDescription(),
                campaignPO.getPassword(),
                campaignPO.getRuleVersion(),
                campaignPO.getIsPrivate()
        );
    }

    public static CampaignPO toEntity(CampaignDTO campaignDTO) {
        if (campaignDTO == null) {
            return null;
        }
        return new CampaignPO(
                campaignDTO.getName(),
                campaignDTO.isPrivate(),
                campaignDTO.getPassword(),
                campaignDTO.getDescription(),
                campaignDTO.getRuleVersion()
        );
    }
}
