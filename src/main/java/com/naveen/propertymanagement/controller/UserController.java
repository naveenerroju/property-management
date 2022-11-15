package com.naveen.propertymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.propertymanagement.dto.UserDto;
import com.naveen.propertymanagement.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired private UserServiceImpl service;
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@RequestBody UserDto dto){
		UserDto response = service.register(dto);
		ResponseEntity<UserDto> responseEntity = new ResponseEntity<UserDto>(response, HttpStatus.CREATED);
		return responseEntity;
	}

}
