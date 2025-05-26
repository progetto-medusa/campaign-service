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

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "is_private")
    private boolean bePrivate;

    @Column(length = 50)
    private String password;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(name = "rule_version", nullable = false, length = 20)
    private String ruleVersion;


}