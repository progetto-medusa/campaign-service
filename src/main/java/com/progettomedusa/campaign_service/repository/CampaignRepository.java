package com.progettomedusa.campaign_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.progettomedusa.campaign_service.model.po.CampaignPO;

public interface CampaignRepository extends JpaRepository<CampaignPO, Long> {
}
