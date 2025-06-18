package com.progettomedusa.campaign_service.controller;

import com.progettomedusa.campaign_service.config.AppProperties;
import com.progettomedusa.campaign_service.model.converter.CampaignConverter;
import com.progettomedusa.campaign_service.model.dto.CampaignDTO;
import com.progettomedusa.campaign_service.model.exception.ErrorMsg;
import com.progettomedusa.campaign_service.model.po.CampaignPO;
import com.progettomedusa.campaign_service.model.request.CreateCampaignRequest;
import com.progettomedusa.campaign_service.model.request.UpdateCampaignRequest;
import com.progettomedusa.campaign_service.model.response.*;
import com.progettomedusa.campaign_service.model.response.Error;
import com.progettomedusa.campaign_service.service.CampaignService;
import com.progettomedusa.campaign_service.util.Tools;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.progettomedusa.campaign_service.util.Constants.CAMPAIGN_NOT_FOUND_MESSAGE;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CampaignController {

    private final CampaignService campaignService;
    private final CampaignConverter campaignConverter;
    private final Tools tools;
    private final AppProperties appProperties;

    @PostMapping("/campaign")
    public ResponseEntity<CreateRequestResponse> createCampaign(@RequestHeader("X-APP-KEY") String appKey, @Valid @RequestBody CreateCampaignRequest createCampaignRequest) {
      log.info("Controller - createCampaign START with request -> {}", createCampaignRequest);
      CampaignDTO campaignDTO = campaignConverter.createRequestToCampaignDTO(createCampaignRequest);
      CreateRequestResponse createRequestResponse = campaignService.createCampaign(campaignDTO);
      log.info("Controller - createCampaign END with response -> {}", createRequestResponse);
      return new ResponseEntity<>(createRequestResponse, HttpStatus.ACCEPTED);
    }

    @GetMapping("/campaigns")
    public ResponseEntity<GetCampaignsResponse> getCampaigns() {
        log.info("Controller - getCmpaigns: START");
        GetCampaignsResponse getCampaignsResponse = campaignService.getCampaigns();
        log.info("Controller - getCampaigns END with response -> {}", getCampaignsResponse);

        if (getCampaignsResponse.getDetailed() == null) {
            return new ResponseEntity<>(getCampaignsResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(getCampaignsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/campaign/{id}")
    public ResponseEntity<GetCampaignResponse> getCampaign(@PathVariable Long id) {
        log.info("Controller - getCampaign START with id -> {}", id);
        GetCampaignResponse getCampaignResponse = campaignService.getCampaign(id);
        log.info("Controller - getCampaign END with response -> {}", getCampaignResponse);

        if (getCampaignResponse.getMessage() == null) {
            return new ResponseEntity<>(getCampaignResponse, HttpStatus.OK);
        } else if (getCampaignResponse.getMessage().equals(CAMPAIGN_NOT_FOUND_MESSAGE)) {
            return new ResponseEntity<>(getCampaignResponse, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(getCampaignResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/campaign/{id}")
    public ResponseEntity<Object> updateCampaign(@Valid @RequestBody UpdateCampaignRequest updateCampaignRequest) {
        log.info("Controller - updateCampaign START with request -> {}", updateCampaignRequest);
        CampaignDTO campaignDTO = campaignConverter.updateRequestToDto(updateCampaignRequest);
        UpdateCampaignResponse updateCampaignResponse = campaignService.updateCampaign(campaignDTO);
        log.info("Controller - updateCampaign END with response -> {}", updateCampaignResponse);
        return new ResponseEntity<>(updateCampaignResponse, HttpStatus.OK);

    }

    @DeleteMapping("/campaign/{id}")
    public ResponseEntity<Object> deleteCampaign(@PathVariable Long id) {
        log.info("Controller - deleteCampaign START with id -> {}", id);
        DeleteCampaignResponse deleteCampaignResponse = campaignService.deleteCampaign(id);
        log.info("Controller - deleteCampaign END with response -> {}", deleteCampaignResponse);
        return new ResponseEntity<>(deleteCampaignResponse, HttpStatus.ACCEPTED);
    }
}
