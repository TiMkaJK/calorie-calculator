package com.faceit.caloriecalculator.data.mapper;

import com.faceit.caloriecalculator.data.dto.UserDTO;
import com.faceit.caloriecalculator.data.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {

}
