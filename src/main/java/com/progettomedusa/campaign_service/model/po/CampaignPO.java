package com.progettomedusa.campaign_service.model.po;

import jakarta.persistence.*;

@Entity
@Table(name = "campaign")
public class CampaignPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "is_private")
    private Boolean isPrivate;

    @Column(length = 50)
    private String password;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(name = "rule_version", nullable = false, length = 20)
    private String ruleVersion;

   // @Column(name = "user_id")
    //private String usersId;
   /* @OneToOne
    @MapsId
    @JoinColumn(name = "id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_id"))
    private String user;*/
    // Costruttore vuoto
    public CampaignPO() {}

    // Costruttore con parametri

    public CampaignPO(String name, Boolean isPrivate, String password, String description, String ruleVersion) {
        this.name = name;
        this.isPrivate = isPrivate;
        this.password = password;
        this.description = description;
        this.ruleVersion = ruleVersion;
        //this.usersId = usersId;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    /*public String getUsersId() {
        return usersId;
    }*/

   /* public void setUsersId(String user) {
        this.usersId = usersId;
    }*/
/* public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}