package com.progettomedusa.campaign_service.service;

import com.progettomedusa.campaign_service.model.dto.CampaignDTO;
import com.progettomedusa.campaign_service.model.po.CampaignPO;
import com.progettomedusa.campaign_service.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.progettomedusa.campaign_service.model.converter.CampaignConverter;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    private final CampaignConverter campaignConverter;


    public CampaignPO createCampaign(CampaignDTO campaignDTO) {
        CampaignPO campaign = campaignConverter.toEntity(campaignDTO);
        log.debug("DTO convertito in entità campagna: " + campaign);
        return campaignRepository.save(campaign);
    }

    public List<CampaignDTO> getAllCampaigns() {
        List<CampaignPO> campaigns = campaignRepository.findAll();

        List<CampaignDTO> campaignDTOs = new ArrayList<>();
        for (CampaignPO campaign : campaigns) {
            campaignDTOs.add(CampaignConverter.campaignDTO(campaign));
            log.debug("Campagna trovata: " + campaign);
        }
        return campaignDTOs;
    }

    public CampaignPO getCampaignById(Long id) {
//        CampaignPO currentcampaign = campaignRepository.getById(id);
//        return currentcampaign;
        return null;
    }

    public CampaignPO updateCampaign(Long id, CampaignDTO campaignDTO) {
        log.debug("DTO convertito in entità campagna: " + campaignDTO);
        CampaignPO currentCampaign = campaignRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Non esiste nessuna campagna con id: " + id));
        currentCampaign.setName(campaignDTO.getName());
        currentCampaign.setDescription(campaignDTO.getDescription());
        currentCampaign.setPassword(campaignDTO.getPassword());
        currentCampaign.setRuleVersion(campaignDTO.getRuleVersion());
        currentCampaign.setBePrivate(campaignDTO.isBePrivate());
//        return campaignRepository.save(currentcampaign);
        return campaignRepository.save(currentCampaign);
    }
    public void deleteCampaign(Long id) {
        log.debug("Sono stati cancellati i dati della campagna con id:");
        if(!campaignRepository.existsById(id)) {
            throw new RuntimeException("Non esiste nessuna campagna con id: " + id);
        }
        campaignRepository.deleteById(id);
    }
}
