package com.faceit.caloriecalculator.service;

import com.faceit.caloriecalculator.data.entity.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.io.InputStream;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatGPTService {

    private final ChatClient chatClient;

    private static final String SYSTEM_REQUEST =
        """
            You are a very useful assistant. Help me with determining the caloric content of products
            """;

    private static final String USER_REQUEST =
        """
                The photo shows food products for a meal. Determine which products are shown in the photo and return them ONLY as a JSON list, where each list element should contain:\s
                * “name” - the name of the product,\s
                * "weight" - weight in grams,\s
                * "kilocalories" - how many calories are contained in this product in 100 grams,\s
                * "proteins" - the amount of proteins of this product per 100 grams,\s
                * "fats" - the amount of fat per 100 grams of this product,\s
                * "carbohydrates" - the amount of carbohydrates per 100 grams of this product,\s
                * "fiber" - the amount of fiber per 100 grams of this product.\s
            """;

    public List<Item> getMealItems(String contentType, InputStream imageInputStream, String locale) {
        return chatClient.prompt()
            .system(systemMessage -> systemMessage.text(SYSTEM_REQUEST))
            .user(userMessage -> userMessage
                .text(USER_REQUEST)
                .media(MimeTypeUtils.parseMimeType(contentType),
                    new InputStreamResource(imageInputStream)))
            .call()
            .entity(new ParameterizedTypeReference<List<Item>>() {});
    }
}
