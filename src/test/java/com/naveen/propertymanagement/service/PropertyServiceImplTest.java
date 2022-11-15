package com.naveen.propertymanagement.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.naveen.propertymanagement.converter.PropertyConverter;
import com.naveen.propertymanagement.dto.PropertyDto;
import com.naveen.propertymanagement.entity.PropertyEntity;
import com.naveen.propertymanagement.entity.UserEntity;
import com.naveen.propertymanagement.repository.PropertyRepository;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceImplTest {
	
	@InjectMocks private PropertyServiceImpl propertyService;
	
	@Mock private PropertyRepository propertyRepository;
	@Mock private PropertyConverter propertyConverter;
	
	@Test
	@Disabled
	void saveProperty_failure() {
		
		PropertyDto propertyDto = new PropertyDto();
		propertyDto.setTitle("2BHK in kukatpally");
		propertyDto.setUserId(12L);
		
		PropertyEntity propertyEntity = new PropertyEntity();
		propertyEntity.setTitle("2BHK in kukatpally");
		propertyEntity.setUserEntity(new UserEntity());
		
		when(propertyRepository.save(Mockito.any())).thenReturn(propertyEntity);
		when(propertyConverter.dtoToEntity(Mockito.any())).thenReturn(propertyEntity);
		when(propertyConverter.entityToDto(Mockito.any())).thenReturn(propertyDto);
		
		PropertyDto actual = propertyService.saveProperty(propertyDto);
		
		Assertions.assertEquals(actual.getId(), 1L);
		
		//this.userRepository is null
		//mock userRepository and add When.thenReturn
		
	}

}
