package com.faceit.caloriecalculator.repository;

import com.faceit.caloriecalculator.data.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
