package com.faceit.caloriecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CalorieCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalorieCalculatorApplication.class, args);
    }

}
