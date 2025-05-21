package com.progettomedusa.campaign_service.controller;

import com.progettomedusa.campaign_service.model.dto.CampaignDTO;
import com.progettomedusa.campaign_service.model.po.CampaignPO;
import com.progettomedusa.campaign_service.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CampaignController {


    private static final Logger logger = LoggerFactory.getLogger(CampaignService.class);


    @Autowired
    CampaignService campaignService;

    //
    @GetMapping("/campaigns")
    public ResponseEntity<List<CampaignDTO>> getAllCampaigns() {
        logger.info("Sono stati recuperati tutti i dati delle campagne");
        try {
            List<CampaignDTO> campaignDTOs = campaignService.getAllCampaigns();
            return new ResponseEntity<>(campaignDTOs, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Errore durante la recuperazione dei dati delle campagne", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Campaign> getCampaignById(@PathVariable Long id) {
//        return ResponseEntity.ok().build();
//    }

    @PostMapping("/api/campaign")
    public ResponseEntity<Object> createCampaign(@RequestBody CampaignDTO campaignDTO) {
        campaignService.createCampaign(campaignDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //
    @PutMapping("/campaign/{id}")
    public ResponseEntity<String> updateCampaign(@PathVariable Long id, @RequestBody CampaignDTO campaign) {
        logger.info("Sono stati aggiornati i dati della campagna con id: " + id);
        try {
            CampaignPO updatedCampaign = campaignService.updateCampaign(id, campaign);
            return ResponseEntity.ok("Campagna aggiornata con successo" + id);
        } catch (Exception e) {
            logger.error("Errore durante l'aggiornamento dei dati della campagna con id: " + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante l'aggiornamento dei dati della campagna con id: " + id + e.getMessage());
        }
    }

    @DeleteMapping("/campaign/{id}")
    public ResponseEntity<String> deleteCampaign(@PathVariable Long id) {
        logger.info("Sono stati cancellati i dati della campagna con id: " + id);
        try {
            campaignService.deleteCampaign(id);
            return ResponseEntity.ok("Campagna cancellata con successo" + id);
        } catch (Exception e) {
            logger.error("Errore durante la cancellazione dei dati della campagna con id: " + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante la cancellazione dei dati della campagna con id: " + id + e.getMessage());
        }
    }
}
