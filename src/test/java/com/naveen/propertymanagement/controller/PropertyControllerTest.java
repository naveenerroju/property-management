package com.naveen.propertymanagement.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.naveen.propertymanagement.dto.PropertyDto;
import com.naveen.propertymanagement.service.PropertyServiceImpl;

@ExtendWith(MockitoExtension.class)
class PropertyControllerTest {
	
	@InjectMocks private PropertyController controller;
	
	@Mock private PropertyServiceImpl propertyService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	@DisplayName("saving a property in success scenario")
	void savePropertyTest() {
		
		PropertyDto propertyDto = new PropertyDto();
		propertyDto.setTitle("2BHK in kukatpally");
		propertyDto.setUserId(1L);
		
		PropertyDto savedProperty = new PropertyDto();
		savedProperty.setTitle("2BHK in kukatpally");
		savedProperty.setUserId(1L);
		savedProperty.setId(1L);
		
		Mockito.when(propertyService.saveProperty(Mockito.any())).thenReturn(savedProperty);
		
		controller.saveProperty(propertyDto);
		ResponseEntity<PropertyDto> responseEntity = controller.saveProperty(propertyDto);
		
		Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
		
	}
	
	@Test
	@DisplayName("Get property by Id with success scenario")
	void getPropertyTest() {
		
		PropertyDto propertyDto = new PropertyDto();
		propertyDto.setTitle("2BHK in kukatpally");
		propertyDto.setUserId(1L);
		
		PropertyDto savedProperty = new PropertyDto();
		savedProperty.setTitle("2BHK in kukatpally");
		savedProperty.setUserId(1L);
		savedProperty.setId(1L);
		
		Mockito.when(propertyService.getProperty(Mockito.any())).thenReturn(savedProperty);
		
		controller.getProperty(1L);
		ResponseEntity<PropertyDto> responseEntity = controller.getProperty(1L);
		
		logger.debug(responseEntity.getBody().toString());
		
		Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		Assertions.assertNotNull(responseEntity.getBody());
	}
	
	
	@Test
	@DisplayName("Update property by Id with success scenario")
	void updatePropertyTest() {
		
		PropertyDto propertyDto = new PropertyDto();
		propertyDto.setTitle("2BHK in kukatpally");
		propertyDto.setUserId(1L);
		
		Mockito.when(propertyService.updateProperty(Mockito.anyLong(), Mockito.any())).thenReturn(propertyDto);
		
		ResponseEntity<PropertyDto> responseEntity = controller.updateProperty(1L, propertyDto);
		
		Assertions.assertEquals(responseEntity.getStatusCodeValue(), 202);
		Assertions.assertNotNull(responseEntity.getBody());
		
	}
	

	
	@Test
	@DisplayName("Update description property by Id with success scenario")
	void updateDescPropertyTest() {
		
		PropertyDto propertyDto = new PropertyDto();
		propertyDto.setTitle("2BHK in kukatpally");
		propertyDto.setUserId(1L);
		propertyDto.setDescription("property has all government approvals");
		
		Mockito.when(propertyService.updateProperty(Mockito.anyLong(), Mockito.any())).thenReturn(propertyDto);
		ResponseEntity<PropertyDto> responseEntity = controller.updateDescription(1L, propertyDto.getDescription());
		
		Assertions.assertEquals(responseEntity.getStatusCodeValue(), 202);
		
		//Assertions.assertNotNull(responseEntity.getBody());
		
		Assertions.assertEquals("property has all government approvals", responseEntity.getBody().getDescription());

	}


}
