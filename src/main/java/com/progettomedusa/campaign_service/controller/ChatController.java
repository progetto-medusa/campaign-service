package com.progettomedusa.campaign_service.controller;

import com.progettomedusa.campaign_service.model.ChatMessage;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.stereotype.Controller;
//
//@RestController
//@Controller("/api/chat")
public class ChatController {
//
//    //GET ALL
//    @GetMapping
//    public ResponseEntity<List<ChatMessage>> getAllChats() {
//        return ResponseEntity.ok().build();
//    }
//
//    //GET
//    @GetMapping("/{id}")
//    public ResponseEntity<ChatMessage> getChatById(@PathVariable Long id) {
//        return ResponseEntity.ok().build();
//    }
//
//    //POST
//    @PostMapping
//    public ResponseEntity<ChatMessage> createChat(@RequestBody ChatMessage chatMessage) {
//        return ResponseEntity.ok().build();
//    }
//
//    //PUT
//    @PutMapping("/{id}")
//    public ResponseEntity<ChatMessage> updateChat(@PathVariable Long id, @RequestBody ChatMessage chatMessage) {
//        return ResponseEntity.ok().build();
//    }
//
//    //DEL
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteChat(@PathVariable Long id) {
//        return ResponseEntity.ok().build();
//    }
   /* @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }
    
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage message) {
        return message;
    }*/
}