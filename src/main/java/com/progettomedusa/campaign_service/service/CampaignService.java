package com.progettomedusa.campaign_service.service;

import com.progettomedusa.campaign_service.model.dto.CampaignDTO;
import com.progettomedusa.campaign_service.model.dto.CampaignSearchDTO;
import com.progettomedusa.campaign_service.model.exception.ErrorMsg;
import com.progettomedusa.campaign_service.model.po.CampaignPO;
import com.progettomedusa.campaign_service.model.response.*;
import com.progettomedusa.campaign_service.model.response.Error;
import com.progettomedusa.campaign_service.repository.CampaignRepository;
import com.progettomedusa.campaign_service.repository.CampaignRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.progettomedusa.campaign_service.model.converter.CampaignConverter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;
    private final PasswordEncoder passwordEncoder;
    private final CampaignConverter campaignConverter;
    private final CampaignRepositoryImpl campaignRepositoryImpl;

    public CreateRequestResponse createCampaign(CampaignDTO campaignDTO) {
        log.info("Service - Create Campaign START with DTO -> {}", campaignDTO);

        /*if (campaignDTO.isBePrivate()) {
            String password = campaignDTO.getPassword();
            if (password == null || password.length() < 8 || password.length() > 24) {
                ErrorMsg errorMsg = ErrorMsg.CPGSRV17;
                Error error = new Error();
                error.setCode(errorMsg.getCode());
                error.setMessage(errorMsg.getMessage());
                error.setDomain("campaign-service");
                error.setDetailed("Provided password was either null or wasn't between 8 and 24 characters");
                error.setTraceId(UUID.randomUUID().toString());

                CreateRequestResponse errorResponse = new CreateRequestResponse();
                errorResponse.setError(error);
                errorResponse.setErrorMsg(errorMsg);

                return errorResponse;
            }
        }*/

        CreateRequestResponse createRequestResponse;
        try {
            if(campaignDTO.getPassword() != null) {
                log.debug("Service - codifica della password START");
                String encodedPassword = passwordEncoder.encode(campaignDTO.getPassword());
                campaignDTO.setPassword(encodedPassword);
                log.debug("Service - codifica della password END");
            }
            CampaignPO campaignToCreate = campaignConverter.dtoToPoForCreate(campaignDTO);

            CampaignPO createdCampaign = campaignRepository.save(campaignToCreate);
            createRequestResponse = campaignConverter.createRequestResponse(createdCampaign);
        } catch(Exception e) {
            log.error("Service - createCampaign ERROR with message -> {}", e.getMessage());
            createRequestResponse = campaignConverter.createRequestResponse(e);
        }
        log.info("Service - createCampaign END with response -> {}", createRequestResponse);
        return createRequestResponse;
    }

    public GetCampaignsResponse getCampaigns() {
        log.info("Service - getCampaigns START ");

        List<CampaignPO> campaignPOList = campaignRepository.findAll();
        GetCampaignsResponse getCampaignsResponse = campaignConverter.listOfCampaignsGetCampaignsResponse(campaignPOList);

        log.info("Service - getCampaigns END with response -> {}", getCampaignsResponse);
        return getCampaignsResponse;
    }

    public GetCampaignResponse getCampaign(Long id) {
        log.info("Service - getCampaign START with id -> {}", id);

        Optional<CampaignPO> campaignPO = campaignRepository.findById(id);

        GetCampaignResponse getCampaignResponse;
        if (campaignPO.isPresent()) {
            getCampaignResponse = campaignConverter.campaignPoToGetCampaignResponse(campaignPO.get(), false);
        } else {
            getCampaignResponse = campaignConverter.getCampaignResponse();
        }
        log.info("Service - getCampaign END with response -> {}", getCampaignResponse);
        return getCampaignResponse;
    }

    public UpdateCampaignResponse updateCampaign(CampaignDTO campaignDTO) {
        log.info("Service - updateCampaign START with DTO -> {}", campaignDTO);
        CampaignPO campaignToUpdate = campaignConverter.dtoToPoForUpdate(campaignDTO);
        CampaignPO currentCampaign = campaignRepository.save(campaignToUpdate);
        UpdateCampaignResponse updateCampaignResponse = campaignConverter.campaignToUpdateResponse(currentCampaign);

        log.info("Service - updateCampaign START with updateCampaignResponse -> {}", updateCampaignResponse);
        return updateCampaignResponse;
    }

    public DeleteCampaignResponse deleteCampaign(Long id) {
        log.info("Service - deleteCampaign START with id -> {}", id);
        campaignRepository.deleteById(id);
        DeleteCampaignResponse deleteCampaignResponse = campaignConverter.deleteCampaignResponse();
        return deleteCampaignResponse;
    }

    public SearchCampaignResponse searchCampaigns(String startDate, String campaignName, String creatorUuid, String limit) {
        CampaignSearchDTO searchDTO = new CampaignSearchDTO();
        searchDTO.setStartDate(startDate);
        searchDTO.setCampaignName(campaignName);
        searchDTO.setCreatorUuid(creatorUuid);
        searchDTO.setLimit(limit);

        List<CampaignPO> filteredCampaigns = campaignRepositoryImpl.findFilteredCampaigns(searchDTO);

        return campaignConverter.listOfCampaignsToSearchCampaignResponse(filteredCampaigns);
    }
}
