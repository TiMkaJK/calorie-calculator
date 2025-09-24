package com.faceit.caloriecalculator.repository;

import com.faceit.caloriecalculator.data.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
