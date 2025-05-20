package com.progettomedusa.campaign_service.controller;

import com.progettomedusa.campaign_service.model.dto.CampaignDTO;
import com.progettomedusa.campaign_service.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CampaignController {

    @Autowired
    CampaignService campaignService;

//
//    @GetMapping
//    public ResponseEntity<List<Campaign>> getAllCampaigns() {
//        return ResponseEntity.ok().build();
//    }
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
//    @PutMapping("/{id}")
//    public ResponseEntity<Campaign> updateCampaign(@PathVariable Long id, @RequestBody Campaign campaign) {
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) {
//        return ResponseEntity.ok().build();
//    }
}
