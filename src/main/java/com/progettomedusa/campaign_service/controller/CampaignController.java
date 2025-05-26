package com.progettomedusa.campaign_service.controller;

import com.progettomedusa.campaign_service.config.AppProperties;
import com.progettomedusa.campaign_service.model.converter.CampaignConverter;
import com.progettomedusa.campaign_service.model.dto.CampaignDTO;
import com.progettomedusa.campaign_service.model.po.CampaignPO;
import com.progettomedusa.campaign_service.model.response.RestResponse;
import com.progettomedusa.campaign_service.service.CampaignService;
import com.progettomedusa.campaign_service.util.Tools;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CampaignController {

    private final CampaignService campaignService;
    private final CampaignConverter campaignConverter;
    private final Tools tools;
    private final AppProperties appProperties;

    @PostMapping("/campaign")
    public ResponseEntity<Object> createCampaign(HttpServletRequest httpServletRequest, @RequestBody CampaignDTO campaignDTO) {
      log.info("Sono stati creati i dati della campagna");

      campaignService.createCampaign(campaignDTO);

        RestResponse restResponse = new RestResponse();
        restResponse.setMessage("Campagna creata con successo");
        restResponse.setDetailed("Nome campagna creato: " + campaignDTO.getName());
        restResponse.setDomain(appProperties.getName());
        restResponse.setTimestamp(tools.getInstant());

        log.info("Controller - creazione campagna: DONE");
        return new ResponseEntity<>(restResponse, HttpStatus.CREATED);
    }

    @GetMapping("/campaign")
    public ResponseEntity<Object> getAllCampaigns(HttpServletRequest httpServletRequest) {
        log.info("Controller - recuper lista campagne: START");
        List<CampaignDTO> campaignDTOs = campaignService.getAllCampaigns();

        List<CampaignPO> campaignPOs = new ArrayList<>();

        for (CampaignDTO campaignDTO : campaignDTOs) {
            campaignPOs.add(campaignConverter.toEntity(campaignDTO));
        }
        RestResponse restResponse = campaignConverter.buildGetUserResponse(campaignPOs, null);
        log.info("Controller - recuper lista campagne: END");
        return new ResponseEntity<>(restResponse, HttpStatus.OK);
        }

//    @GetMapping("/{id}")
//    public ResponseEntity<Campaign> getCampaignById(@PathVariable Long id) {
//        return ResponseEntity.ok().build();
//    }

    @PutMapping("/campaign/{id}")
    public ResponseEntity<Object> updateCampaign(HttpServletRequest httpServletRequest, @PathVariable Long id, @RequestBody CampaignDTO campaignDTO) {
        log.info("Controller - aggiornamento campagna con ID {}: START", id);

        campaignService.updateCampaign(id, campaignDTO);

        RestResponse restResponse = new RestResponse();
        restResponse.setMessage("Campagna aggiornata con successo");
        restResponse.setDetailed("Nome campagna aggiornato: " + campaignDTO.getName());
        restResponse.setDomain(appProperties.getName());
        restResponse.setTimestamp(tools.getInstant());

        log.info("Controller - aggiornamento campagna con ID {}: DONE", id);
        return new ResponseEntity<>(restResponse, HttpStatus.OK);

    }

    @DeleteMapping("/campaign/{id}")
    public ResponseEntity<Object> deleteCampaign(HttpServletRequest httpServletRequest, @PathVariable Long id) {
        log.info("Controller - cancellazione campagna con ID {}: START", id);
        campaignService.deleteCampaign(id);

        RestResponse restResponse = new RestResponse();
        restResponse.setMessage("Campagna cancellata con successo");
        restResponse.setDetailed("Nome campagna cancellato: " + id);
        restResponse.setDomain(appProperties.getName());
        restResponse.setTimestamp(tools.getInstant());

        log.info("Controller - cancellazione campagna con ID {}: DONE", id);
        return new ResponseEntity<>(restResponse, HttpStatus.OK);
    }
}
