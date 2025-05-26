package com.progettomedusa.campaign_service.model.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")


public class CampaignDTO {
    private String name;
    private String description;
    private String password;
    private String ruleVersion;
    //private String userId;
    private boolean bePrivate;


   /* public CampaignDTO(String name, String description, String password, String ruleVersion, boolean isPrivate) {
        this.name = name;
        this.description = description;
        this.password = password;
        this.ruleVersion = ruleVersion;
        this.isPrivate = isPrivate;
        //this.userId = userId;
    }

   public String getName() { return name; }
   public String getDescription() { return description; }
   public String getPassword() { return password; }
   public String getRuleVersion() { return ruleVersion; }
   public boolean isPrivate() { return isPrivate; }*/
   /*public String getUserId() {
        return userId;
    }*/

   /* public void setUserId(String userId) {
        this.userId = userId;
    }*/
 /*  public void setName(String name) { this.name = name; }
   public void setDescription(String description) { this.description = description; }
   public void setPassword(String password) { this.password = password; }
   public void setRuleVersion(String ruleVersion) { this.ruleVersion = ruleVersion; }
   public void setPrivate(boolean isPrivate) { this.isPrivate = isPrivate; }
*/;

   /*@Override
   public String toString() {
       return "CampaignDTO{" +
               "name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", password='" + password + '\'' +
               ", ruleVersion='" + ruleVersion + '\'' +
               ", isPrivate=" + isPrivate +
               '}';
   }*/
}
