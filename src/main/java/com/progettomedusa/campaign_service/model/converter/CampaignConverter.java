package com.progettomedusa.campaign_service.model.converter;

import com.progettomedusa.campaign_service.config.AppProperties;
import com.progettomedusa.campaign_service.model.request.CreateCampaignRequest;
import com.progettomedusa.campaign_service.model.request.UpdateCampaignRequest;
import com.progettomedusa.campaign_service.model.response.*;
import com.progettomedusa.campaign_service.util.Tools;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.progettomedusa.campaign_service.model.dto.CampaignDTO;
import com.progettomedusa.campaign_service.model.po.CampaignPO;

import java.util.ArrayList;
import java.util.List;

import static com.progettomedusa.campaign_service.util.Constants.BASE_ERROR_DETAILS;

@Slf4j
@RequiredArgsConstructor
@Component
public class CampaignConverter {

    private final Tools tools;
    private final AppProperties campaignApplicationProperties;

    public CampaignDTO createRequestToCampaignDTO(CreateCampaignRequest createCampaignRequest) {
        CampaignDTO campaignDTO = new CampaignDTO();
        campaignDTO.setName(createCampaignRequest.getName());
        campaignDTO.setDescription(createCampaignRequest.getDescription());
        campaignDTO.setRuleVersion(createCampaignRequest.getRuleVersion());
        campaignDTO.setApplicationId(createCampaignRequest.getApplicationId());
        campaignDTO.setBePrivate(createCampaignRequest.isBePrivate());
        campaignDTO.setInsertDate(tools.getInstant());
        campaignDTO.setUpdateDate(tools.getInstant());
        campaignDTO.setCreatorUuid(createCampaignRequest.getCreatorUuid());


        if (createCampaignRequest.isBePrivate()) {
            campaignDTO.setPassword(createCampaignRequest.getPassword());
        }
        return campaignDTO;
    }

    public CreateRequestResponse createRequestResponse(CampaignPO campaignCreated) {
        CreateRequestResponse createRequestResponse = new CreateRequestResponse();
        createRequestResponse.setMessage("Campagna creata con successo");
        createRequestResponse.setDomain(campaignApplicationProperties.getName());
        createRequestResponse.setTimestamp(tools.getInstant());
        createRequestResponse.setDetailed("Nome campagna creato: " + campaignCreated.getName());
        log.info("CampaignConverter - createRequestResponse END with createRequestRespons -> {}e", createRequestResponse);
        return createRequestResponse;
    }

    public CreateRequestResponse createRequestResponse(Exception e) {
        CreateRequestResponse createRequestResponse = new CreateRequestResponse();
        createRequestResponse.setMessage(e.getMessage());
        createRequestResponse.setDomain(campaignApplicationProperties.getName());
        createRequestResponse.setTimestamp(tools.getInstant());
        createRequestResponse.setDetailed(BASE_ERROR_DETAILS);
        log.error("CampaignConverter - createRequestResponse END with createRequestResponse -> {}", createRequestResponse);
        return createRequestResponse;
    }
//
public CampaignPO dtoToPoForCreate(CampaignDTO campaignDTO) {
    CampaignPO campaignPO = new CampaignPO();
    if (campaignDTO.getId() != null) {
        campaignPO.setId(Long.valueOf(campaignDTO.getId()));
    }
    campaignPO.setName(campaignDTO.getName());
    campaignPO.setDescription(campaignDTO.getDescription());
    campaignPO.setRuleVersion(campaignDTO.getRuleVersion());
    campaignPO.setApplicationId(campaignDTO.getApplicationId());
    campaignPO.setBePrivate(campaignDTO.isBePrivate());
    campaignPO.setInsertDate(tools.getInstant());
    campaignPO.setUpdateDate(tools.getInstant());
    campaignPO.setCreatorUuid(campaignDTO.getCreatorUuid());
    if (campaignDTO.isBePrivate()) {
        campaignPO.setPassword(campaignDTO.getPassword());
    }
    log.info("CampaignConverter - dtoToPoForCreate END with campaignPO -> {}", campaignPO);
    return campaignPO;
}
    public CampaignPO dtoToPoForUpdate(CampaignDTO campaignDTO) {
        CampaignPO campaignPO = new CampaignPO();
        if (campaignDTO.getId() != null) {
            campaignPO.setId(Long.valueOf(campaignDTO.getId()));
        }
        campaignPO.setName(campaignDTO.getName());
        campaignPO.setDescription(campaignDTO.getDescription());
        campaignPO.setRuleVersion(campaignDTO.getRuleVersion());
        campaignPO.setApplicationId(campaignDTO.getApplicationId());
        campaignPO.setUpdateDate(tools.getInstant());
        if (campaignDTO.isBePrivate()) {
            campaignPO.setPassword(campaignDTO.getPassword());
        }
        log.info("CampaignConverter - dtoToPoForUpdate END with campaignPO -> {}", campaignPO);
        return campaignPO;
    }

    public GetCampaignsResponse listOfCampaignsGetCampaignsResponse(List<CampaignPO> campaignPOList) {
        GetCampaignsResponse getCampaignsResponse = new GetCampaignsResponse();

        List<GetCampaignResponse> getCampaignResponseList = new ArrayList<>();

        for (CampaignPO campaignPO : campaignPOList) {
            GetCampaignResponse getCampaignResponse = campaignPoToGetCampaignResponse(campaignPO, true);
            getCampaignResponseList.add(getCampaignResponse);
        }

        getCampaignsResponse.setCampaigns(getCampaignResponseList);
        getCampaignsResponse.setDomain(campaignApplicationProperties.getName());
        getCampaignsResponse.setTimestamp(tools.getInstant());

        log.info("CampaignConverter - listOfCampaignsGetCampaignsResponse END with getCampaignsResponse -> {}", getCampaignsResponse);
        return getCampaignsResponse;
    }

    public GetCampaignResponse campaignPoToGetCampaignResponse(CampaignPO campaignPO, boolean internal) {
        GetCampaignResponse getCampaignResponse = new GetCampaignResponse();

        CampaignResponse campaignResponse = new CampaignResponse();
        campaignResponse.setName(campaignPO.getName());
        campaignResponse.setDescription(campaignPO.getDescription());
        getCampaignResponse.setCampaign(campaignResponse);
        if (!internal) {
            getCampaignResponse.setDomain(campaignApplicationProperties.getName());
            getCampaignResponse.setTimestamp(tools.getInstant());
        }
        log.info("CampaignConverter - campaignPoToGetCampaignResponse END with getCampaignResponse -> {}", getCampaignResponse);
        return getCampaignResponse;
    }

    public GetCampaignResponse getCampaignResponse() {
        GetCampaignResponse getCampaignResponse = new GetCampaignResponse();
        getCampaignResponse.setCampaign(new CampaignResponse());
        getCampaignResponse.setMessage("CAMPAIGN_NOT_FOUND_MESSAGE");
        getCampaignResponse.setDomain(campaignApplicationProperties.getName());
        getCampaignResponse.setTimestamp(tools.getInstant());
        log.info("CampaignConverter - getCampaignResponse END with getCampaignResponse -> {}", getCampaignResponse);
        return getCampaignResponse;
    }

    public CampaignDTO updateRequestToDto(UpdateCampaignRequest updateCampaignRequest) {
        CampaignDTO campaignDTO = new CampaignDTO();
        campaignDTO.setId(updateCampaignRequest.getId());
        campaignDTO.setName(updateCampaignRequest.getName());
        campaignDTO.setApplicationId(updateCampaignRequest.getApplicationId());
        campaignDTO.setDescription(updateCampaignRequest.getDescription());
        campaignDTO.setRuleVersion(updateCampaignRequest.getRuleVersion());
        campaignDTO.setUpdateDate(tools.getInstant());

        log.info("CampaignConverter - updateRequestToDto END with campaignDTO -> {}", campaignDTO);
        return campaignDTO;
    }

    public UpdateCampaignResponse campaignToUpdateResponse(CampaignPO campaignUpdated) {
        CampaignResponse campaignResponse = new CampaignResponse();;
        campaignResponse.setName(campaignUpdated.getName());
        campaignResponse.setDescription(campaignUpdated.getDescription());
        campaignResponse.setRuleVersion(campaignUpdated.getRuleVersion());

        UpdateCampaignResponse updateCampaignResponse = new UpdateCampaignResponse();
        updateCampaignResponse.setMessage("Campagna aggiornata con successo");
        updateCampaignResponse.setDomain(campaignApplicationProperties.getName());
        updateCampaignResponse.setTimestamp(tools.getInstant());
        updateCampaignResponse.setDetailed("Nome campagna aggiornato: " + campaignUpdated.getName());
        updateCampaignResponse.setCampaign(campaignResponse);
        log.info("CampaignConverter - campaignToUpdateResponse END with updateCampaignResponse -> {}", updateCampaignResponse);
        return updateCampaignResponse;
    }
    public DeleteCampaignResponse deleteCampaignResponse() {
        DeleteCampaignResponse deleteCampaignResponse = new DeleteCampaignResponse();
        deleteCampaignResponse.setMessage("CAMPAIGN_DELETED_MESSAGE");
        deleteCampaignResponse.setDomain(campaignApplicationProperties.getName());
        deleteCampaignResponse.setTimestamp(tools.getInstant());
        log.info("CampaignConverter - deleteCampaignResponse END with deleteCampaignResponse -> {}", deleteCampaignResponse);
        return deleteCampaignResponse;
    }
}
