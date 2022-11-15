package com.naveen.propertymanagement.converter;

import org.springframework.stereotype.Component;

import com.naveen.propertymanagement.dto.PropertyDto;
import com.naveen.propertymanagement.entity.PropertyEntity;

@Component
public class PropertyConverter {
	
	public PropertyEntity dtoToEntity(PropertyDto dto) {
		
		PropertyEntity entity = new PropertyEntity();
		//entity.setId(dto.getId());	//we do not need this. we are auto generating id
		entity.setDescription(dto.getDescription());
		//entity.setUserEntity(dto.getUserId());
		entity.setPrice(dto.getPrice());
		entity.setTitle(dto.getTitle());
		
		return entity;
	}

	public PropertyDto entityToDto(PropertyEntity entity) {
		
		PropertyDto dto = new PropertyDto();
		
		dto.setId(entity.getId());
		dto.setDescription(entity.getDescription());
		dto.setUserId(entity.getUserEntity().getUserId());
		dto.setPrice(entity.getPrice());
		dto.setTitle(entity.getTitle());
		
		return dto;
	}
	
}
