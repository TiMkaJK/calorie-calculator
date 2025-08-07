package com.faceit.caloriecalculator.service.impl;

import com.faceit.caloriecalculator.data.dto.ItemDTO;
import com.faceit.caloriecalculator.data.entity.Meal;
import com.faceit.caloriecalculator.repository.MealRepository;
import com.faceit.caloriecalculator.service.ChatGPTService;
import com.faceit.caloriecalculator.service.MealService;
import java.io.InputStream;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final ChatGPTService chatGPTService;

    @Override
    public Meal save(String contentType, InputStream imageInputStream) {
        Meal meal = new Meal();
        List<ItemDTO> itemDTOS = chatGPTService.getMealItems(contentType, imageInputStream);

        return null;
    }
}

