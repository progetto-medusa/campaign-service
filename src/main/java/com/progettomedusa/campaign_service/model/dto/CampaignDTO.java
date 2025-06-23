package com.progettomedusa.campaign_service.model.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class CampaignDTO {
    private Long id;
    private String name;
    private String description;
    private String password;
    private String ruleVersion;
    private boolean bePrivate;
    private String insertTime;
    private String updateTime;
    private String applicationId;
/*  private int maxPlayers;
    private String playerUsername;
    private String playerRole;
    private int minPlayers;
    */

}
