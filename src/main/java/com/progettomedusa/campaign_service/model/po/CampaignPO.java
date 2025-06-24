package com.progettomedusa.campaign_service.model.po;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "campaign")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class CampaignPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "is_private")
    private boolean bePrivate;

    @Column(length = 50)
    private String password;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(name = "rule_version", nullable = false)
    private String ruleVersion;

    @Column(name = "update_date", nullable = false)
    private String updateTime;

    @Column(name = "insert_date", nullable = false)
    private String insertTime;

    @Column(name = "application_id", nullable = false)
    private String applicationId;

    @Column(name = "creator_uuid", nullable = false)
    private String creatorUuid;
}