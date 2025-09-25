package com.faceit.caloriecalculator.service;

import com.faceit.caloriecalculator.data.entity.Subscription;

public interface SubscriptionService {

    Subscription findByName(String name);
}
