package com.faceit.caloriecalculator.data.dto;

import com.faceit.caloriecalculator.data.constant.Gender;
import com.faceit.caloriecalculator.data.constant.Language;
import com.faceit.caloriecalculator.data.constant.Subscription;
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
    private Gender gender;
    private Subscription subscription;
    private Language language;
    private Set<MealDTO> meals;
    private Instant createdAt;
    private Instant updatedAt;
}

