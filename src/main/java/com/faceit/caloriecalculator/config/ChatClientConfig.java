package com.faceit.caloriecalculator.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient customChatClient(OpenAiChatModel openAiChatModel) {
        return ChatClient.builder(openAiChatModel)
            // Add advisors or other configurations here
            .build();
    }
}

