package com.naveen.propertymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.propertymanagement.converter.UserConverter;
import com.naveen.propertymanagement.dto.UserDto;
import com.naveen.propertymanagement.entity.UserEntity;
import com.naveen.propertymanagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired private UserRepository repository;
	@Autowired private UserConverter converter;

	@Override
	public UserDto register(UserDto dto) {
		UserEntity entity = converter.dtoToEntity(dto);
		repository.save(entity);
		UserDto response = converter.entityToDto(entity);
		return response;
	}

}
