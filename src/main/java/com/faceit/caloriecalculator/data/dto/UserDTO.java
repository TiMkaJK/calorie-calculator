package com.faceit.caloriecalculator.data.dto;

import com.faceit.caloriecalculator.data.constant.UserGender;
import com.faceit.caloriecalculator.data.constant.UserLanguage;
import com.faceit.caloriecalculator.data.constant.UserSubscription;
import com.faceit.caloriecalculator.data.entity.Language;
import com.faceit.caloriecalculator.data.entity.Subscription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String picture;
    private Instant birthDate;
    private Integer weight;
    private Integer height;
    private UserGender gender;
    private Subscription subscription;
    private Language language;
    private Set<MealDTO> meals;
    private Instant createdAt;
    private Instant updatedAt;
}

