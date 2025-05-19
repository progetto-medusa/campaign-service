package com.progettomedusa.campaign_service.model;

public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;
    
    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}