package com.faceit.caloriecalculator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Slf4j

@Service
public class ChatGPTService {

    private final ChatClient chatClient;

    public ChatGPTService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
}
