package com.naveen.propertymanagement.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Repository;

import com.naveen.propertymanagement.converter.UserConverter;
import com.naveen.propertymanagement.dto.UserDto;
import com.naveen.propertymanagement.entity.UserEntity;
import com.naveen.propertymanagement.repository.UserRepository;
import com.naveen.propertymanagement.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
	
	@InjectMocks private UserController controller;
	
	@Mock private UserServiceImpl service;
	@Mock private UserConverter converter;
	@Mock private UserRepository repository;
	
	@Test
	@DisplayName("Test successs scenario for the registration")
	void registerUserTest() {
		
		UserDto dto = new UserDto();
		dto.setUserName("naveen");
		
		UserDto savedUser = new UserDto();
		dto.setUserName("naveen");
		dto.setUserId(1L);
		

		Mockito.when(service.register(Mockito.any())).thenReturn(savedUser);
		
		ResponseEntity<UserDto> responseEntity = controller.register(dto);
		
		//Assertions.assertNotNull(responseEntity.getBody().getUserId());
		Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
		
	}

}
