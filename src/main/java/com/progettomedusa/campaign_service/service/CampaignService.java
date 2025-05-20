package com.progettomedusa.campaign_service.service;

import com.progettomedusa.campaign_service.model.dto.CampaignDTO;
import com.progettomedusa.campaign_service.model.po.CampaignPO;
import com.progettomedusa.campaign_service.repository.CampaignRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.progettomedusa.campaign_service.model.converter.CampaignConverter;

@Service
public class CampaignService {

    private static final Logger logger = LoggerFactory.getLogger(CampaignService.class);

    @Autowired
    private CampaignRepository campaignRepository;


    public void createCampaign(CampaignDTO campaignDTO) {
        CampaignPO campaign = CampaignConverter.toEntity(campaignDTO);
        logger.debug("DTO convertito in entità campagna: " + campaign);
        campaignRepository.save(campaign);
    }

    public CampaignPO getCampaignById(Long id) {
//        CampaignPO currentcampaign = campaignRepository.getById(id);
//        return currentcampaign;
        return null;
    }

    public CampaignPO updateCampaign(Long id, CampaignDTO campaignDTO) {
        logger.debug("DTO convertito in entità campagna: " + campaignDTO);
//        CampaignPO currentcampaign = campaignRepository.getById(id);
        CampaignPO currentcampaign = new CampaignPO();
        currentcampaign.setName(campaignDTO.getName());
        currentcampaign.setDescription(campaignDTO.getDescription());
        currentcampaign.setPassword(campaignDTO.getPassword());
        currentcampaign.setRuleVersion(campaignDTO.getRuleVersion());
        currentcampaign.setIsPrivate(campaignDTO.isPrivate());
//        return campaignRepository.save(currentcampaign);
        return null;
    }
    public void deleteCampaign(Long id) {
        logger.debug("Sono stati cancellati i dati della campagna con id:");
//        if(!campaignRepository.existsById(id)) {
//            throw new RuntimeException("Non esiste nessuna campagna con id: " + id);
//        }
//        campaignRepository.deleteById(id);
    }
}
