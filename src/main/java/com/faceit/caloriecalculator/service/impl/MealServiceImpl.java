package com.faceit.caloriecalculator.service.impl;

import com.faceit.caloriecalculator.data.entity.Meal;
import com.faceit.caloriecalculator.repository.MealRepository;
import com.faceit.caloriecalculator.service.MealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final ChatClient chatClient;

    @Override
    public Meal save(Meal meal) {
        return null;
    }
}

