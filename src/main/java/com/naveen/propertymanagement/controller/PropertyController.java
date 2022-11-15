package com.naveen.propertymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.propertymanagement.converter.PropertyConverter;
import com.naveen.propertymanagement.dto.PropertyDto;
import com.naveen.propertymanagement.entity.PropertyEntity;
import com.naveen.propertymanagement.service.PropertyServiceImpl;

@RestController
@RequestMapping("api/v1/property")
public class PropertyController {
	
	@Autowired private PropertyServiceImpl service;
	
	@PostMapping("/add")
	public ResponseEntity<PropertyDto> saveProperty(@RequestBody PropertyDto property){
		
		PropertyDto dto = service.saveProperty(property);
		ResponseEntity<PropertyDto> response = new ResponseEntity<PropertyDto>
						(dto, HttpStatus.CREATED);
		
		return response;
				
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<PropertyDto> getProperty(@PathVariable("id") Long id){
		PropertyDto dto = service.getProperty(id);

		ResponseEntity<PropertyDto> response = new ResponseEntity<PropertyDto>
						(dto, HttpStatus.OK);
		
		return response;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<PropertyDto>> getAllProperty(){
		List<PropertyDto> list = service.getAllProperty();
		
		ResponseEntity<List<PropertyDto>> response = new ResponseEntity
				<List<PropertyDto>>(list, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PropertyDto> updateProperty(
			@PathVariable("id") Long id, @RequestBody PropertyDto property){
		
		PropertyDto response = service.updateProperty(id, property);
		ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<PropertyDto>(
				response, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@PatchMapping("/updesc/{id}")
	public ResponseEntity<PropertyDto> updateDescription(@PathVariable("id") Long id, @RequestBody String description){
		
		PropertyDto response = service.updateDescProperty(id, description);
		ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<PropertyDto>(
				response, HttpStatus.ACCEPTED);
		return responseEntity;
		
	}
 	

}
