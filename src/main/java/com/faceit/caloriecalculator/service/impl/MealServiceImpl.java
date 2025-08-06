package com.faceit.caloriecalculator.service.impl;

import com.faceit.caloriecalculator.data.entity.Meal;
import com.faceit.caloriecalculator.repository.MealRepository;
import com.faceit.caloriecalculator.service.MealService;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Slf4j
@RequiredArgsConstructor
@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final ChatClient chatClient;

    @Override
    public Meal save(String contentType, InputStream imageInputStream) {
        ChatResponse response = chatClient.prompt()
            .system(systemMessage -> systemMessage
                .text("You are a very useful assistant. Help me with determining the caloric content of products")
            )
            .user(userMessage -> userMessage
                .text("The photo shows food products for a meal. Determine which products are shown in the photo and return them ONLY as a JSON list, where each list element should contain: * \"title\" - the name of the product, * \"weight\" - weight in grams, * \"kilocalories_per100g\" - how many calories are contained in this product in 100 grams, * \"proteins_per100g\" - the amount of proteins of this product per 100 grams, * \"fats_per100g\" - the amount of fat per 100 grams of this product, * \"carbohydrates_per100g\" - the amount of carbohydrates per 100 grams of this product, * \"fiber_per100g\" - the amount of fiber per 100 grams of this product. Response language - English")
                .media(MimeTypeUtils.parseMimeType(contentType), new InputStreamResource(imageInputStream))
            )
            .call().chatResponse();

        log.info(response.toString());
//            .entity(CarCount.class);
        return null;
    }
}

