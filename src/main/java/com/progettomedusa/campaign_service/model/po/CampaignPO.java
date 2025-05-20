package com.progettomedusa.campaign_service.model.po;

import jakarta.persistence.*;

@Entity
@Table(name = "campaign")
public class CampaignPO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    
    @Column(name = "isPrivate")
    private Boolean isPrivate;
    
    @Column(name = "password", length = 50)
    private String password;
    
    @Column(name = "description", nullable = false, length = 500)
    private String description;
    
    @Column(name = "rule_version", nullable = false, length = 20)
    private String ruleVersion;
    
    /*@ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;*/

    // Costruttore vuoto
    public CampaignPO() {}

    // Costruttore con parametri
    public CampaignPO(String name, Boolean isPrivate, String password,
                      String description, String ruleVersion) {
        this.name = name;
        this.isPrivate = isPrivate;
        this.password = password;
        this.description = description;
        this.ruleVersion = ruleVersion;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRuleVersion() {
        return ruleVersion;
    }

    public void setRuleVersion(String ruleVersion) {
        this.ruleVersion = ruleVersion;
    }

   /* public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}