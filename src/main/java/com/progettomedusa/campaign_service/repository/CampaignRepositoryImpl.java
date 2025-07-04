package com.progettomedusa.campaign_service.repository;

import com.progettomedusa.campaign_service.model.dto.CampaignSearchDTO;
import com.progettomedusa.campaign_service.model.po.CampaignPO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CampaignRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CampaignPO> findFilteredCampaigns(CampaignSearchDTO campaignSearchDTO) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CampaignPO> query = criteriaBuilder.createQuery(CampaignPO.class);
        Root<CampaignPO> root = query.from(CampaignPO.class);

        List<Predicate> conditions = new ArrayList<>();

        if (campaignSearchDTO.getStartDate() != null && !campaignSearchDTO.getStartDate().isEmpty()) {
            String start = campaignSearchDTO.getStartDate().trim();
            conditions.add(criteriaBuilder.greaterThanOrEqualTo(root.get("insertDate"), start));
        }

        if (campaignSearchDTO.getCampaignName() != null && !campaignSearchDTO.getCampaignName().isEmpty()) {
            conditions.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + campaignSearchDTO.getCampaignName().toLowerCase() + "%"));
        }

        if (campaignSearchDTO.getCreatorUuid() != null && !campaignSearchDTO.getCreatorUuid().isEmpty()) {
            Predicate isPublic = criteriaBuilder.isFalse(root.get("bePrivate"));
            Predicate isPrivateAndMine = criteriaBuilder.and(
                    criteriaBuilder.isTrue(root.get("bePrivate")),
                    criteriaBuilder.equal(root.get("creatorUuid"), campaignSearchDTO.getCreatorUuid())
            );
            conditions.add(criteriaBuilder.or(isPublic, isPrivateAndMine));
        } else {
            conditions.add(criteriaBuilder.isFalse(root.get("bePrivate")));
        }

        query.select(root).where(criteriaBuilder.and(conditions.toArray(new Predicate[0])));
        TypedQuery<CampaignPO> typedQuery = entityManager.createQuery(query);

        int maxResults = 100;
        if (campaignSearchDTO.getLimit() != null && !campaignSearchDTO.getLimit().isEmpty()) {
            try {
                maxResults = Integer.parseInt(campaignSearchDTO.getLimit());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid limit value: " + campaignSearchDTO.getLimit());
            }
        }

        typedQuery.setMaxResults(maxResults);

        return typedQuery.getResultList();
    }
}
