package com.faceit.caloriecalculator.service;

import com.faceit.caloriecalculator.data.entity.Language;

public interface LanguageService {

    Language findByName(String name);
}
