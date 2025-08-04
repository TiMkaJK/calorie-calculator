package com.faceit.caloriecalculator.data.mapper;

import com.faceit.caloriecalculator.data.dto.ItemDTO;
import com.faceit.caloriecalculator.data.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper extends EntityMapper<ItemDTO, Item> {

}
