package com.naveen.propertymanagement.converter;

import org.springframework.stereotype.Component;

import com.naveen.propertymanagement.dto.UserDto;
import com.naveen.propertymanagement.entity.UserEntity;

@Component
public class UserConverter {
	
	public UserEntity dtoToEntity(UserDto dto) {
		
		UserEntity entity = new UserEntity();
		entity.setPassword(dto.getPassword());
		entity.setUserName(dto.getUserName());
		
		return entity;
	}
	
	public UserDto entityToDto(UserEntity entity) {
		
		UserDto dto = new UserDto();
		dto.setUserId(entity.getUserId());
		dto.setUserName(entity.getUserName());
		
		return dto;
	}

}
