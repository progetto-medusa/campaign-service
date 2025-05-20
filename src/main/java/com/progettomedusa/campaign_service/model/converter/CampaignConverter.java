package com.progettomedusa.campaign_service.model.converter;

import com.progettomedusa.campaign_service.model.po.UserPO;
import org.springframework.stereotype.Component;
import com.progettomedusa.campaign_service.model.dto.CampaignDTO;
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
                campaignPO.getIsPrivate(),
                campaignPO.getId()
        );
    }

    public static CampaignPO toEntity(CampaignDTO campaignDTO) {
        if (campaignDTO == null) {
            return null;
        }

        CampaignPO campaign = new CampaignPO();
        campaign.setName(campaignDTO.getName());
        campaign.setIsPrivate(Boolean.TRUE.equals(campaignDTO.isPrivate())); // più sicuro
        campaign.setPassword(campaignDTO.getPassword());
        campaign.setDescription(campaignDTO.getDescription());
        campaign.setRuleVersion(campaignDTO.getRuleVersion());

        if (campaignDTO.getUserId() != null) {
            UserPO user = new UserPO();
            user.setId(campaignDTO.getUserId());
            campaign.setUser(user);
        }

        return campaign;
    }
}
