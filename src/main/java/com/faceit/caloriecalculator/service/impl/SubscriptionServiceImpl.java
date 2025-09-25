package com.faceit.caloriecalculator.service.impl;

import com.faceit.caloriecalculator.data.entity.Subscription;
import com.faceit.caloriecalculator.repository.SubscriptionRepository;
import com.faceit.caloriecalculator.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription findByName(String name) {
        return subscriptionRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Subscription with name " + name + " not found"));
    }
}

