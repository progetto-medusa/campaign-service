package com.progettomedusa.campaign_service.model.converter;

import com.progettomedusa.campaign_service.config.AppProperties;
import com.progettomedusa.campaign_service.model.response.RestResponse;
import com.progettomedusa.campaign_service.util.Tools;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import org.springframework.stereotype.Component;
import com.progettomedusa.campaign_service.model.dto.CampaignDTO;
import com.progettomedusa.campaign_service.model.po.CampaignPO;

@Slf4j
@RequiredArgsConstructor
@Component
public class CampaignConverter {

    private final AppProperties appProperties;
    private final Tools tools;

    public RestResponse retrieveRestResponseForRootPath(CampaignDTO campaignDTO) {
        log.debug("Converter - retrieve rest response for root path START with Campaign DT -> {}", campaignDTO);

        RestResponse restResponse = new RestResponse();

        restResponse.setMessage("Service is ONLINE");
        restResponse.setDomain(appProperties.getName());
        restResponse.setDetailed("Called for campaign -> " + campaignDTO.getName());
        restResponse.setTimestamp(tools.getInstant());

        log.debug("Converter - retrieve rest response for root path END with Rest Response -> {}", restResponse);
        return restResponse;
    }
    public static CampaignDTO campaignDTO(CampaignPO campaignPO) {
        log.debug("Converter - Converting CampaignPO to CampaignDTO START for Campaign PO -> {}", campaignPO);

        if (campaignPO == null)  {
            log.warn("Converter - Input CampaignPO is null");
            return null;
        }
        CampaignDTO campaignDTO = new CampaignDTO();
        campaignDTO.setName(campaignPO.getName());
        campaignDTO.setDescription(campaignPO.getDescription());
        campaignDTO.setPassword(campaignPO.getPassword());
        campaignDTO.setRuleVersion(campaignPO.getRuleVersion());
        /*campaignDTO.setUserId(campaignPO.getUser().getId());*/
        log.debug("Converter - Converting CampaignPO to CampaignDTO END with CampaignDTO -> {}", campaignDTO);
        return campaignDTO;
    }

    public CampaignPO toEntity(CampaignDTO campaignDTO) {
        log.debug("Converter - Converting CampaignDTO to CampaignPO START for CampaignDTO -> {}", campaignDTO);
        if (campaignDTO == null) {
            log.warn("Converter - Input CampaignDTO is null");
            return null;
        }

        CampaignPO campaign = new CampaignPO();
        campaign.setName(campaignDTO.getName());
        campaign.setBePrivate(campaignDTO.isBePrivate());
        campaign.setPassword(campaignDTO.getPassword());
        campaign.setDescription(campaignDTO.getDescription());
        campaign.setRuleVersion(campaignDTO.getRuleVersion());
        /*campaign.setUsersId(campaignDTO.getUserId());*/
        /*if (campaignDTO.getUserId() != null) {
            UserPO user = new UserPO();
            user.setId(campaignDTO.getUserId());
            campaign.setUser(user);
        }*/
        log.debug("Converter - Converting CampaignDTO to CampaignPO END with CampaignPO -> {}", campaign);
        return campaign;
    }

    public RestResponse buildGetUserResponse(List<CampaignPO> campaignPOList, CampaignDTO campaignDTO) {
        log.debug("Converter - build get CampaignPO response START with CampaignPOList -> {}, DTO -> {}", campaignPOList, campaignDTO);

        RestResponse restResponse = new RestResponse();
        restResponse.setMessage("CampaignPOList retrieved successfully");
        restResponse.setDomain(appProperties.getName());

        try {
            restResponse.setDetailed("Requested by: " + campaignDTO.getName());
        } catch (NullPointerException e) {
            restResponse.setDetailed("Requested by: Anonymous");
        }

        restResponse.setTimestamp(tools.getInstant());
        log.debug("Converter - build get CampaignPO response END with RestResponse -> {}", restResponse);
        return restResponse;
    }


}
