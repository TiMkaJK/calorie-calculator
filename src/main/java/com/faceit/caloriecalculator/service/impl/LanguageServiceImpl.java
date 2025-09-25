package com.faceit.caloriecalculator.service.impl;

import com.faceit.caloriecalculator.data.entity.Language;
import com.faceit.caloriecalculator.repository.LanguageRepository;
import com.faceit.caloriecalculator.service.LanguageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    public Language findByName(String name) {
        return languageRepository.findByName(name)
                .orElseThrow(NoSuchElementException::new);
    }
}

