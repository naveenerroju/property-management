package com.naveen.propertymanagement.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
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
import com.naveen.propertymanagement.excepetion.BusinessException;
import com.naveen.propertymanagement.excepetion.ErrorModel;
import com.naveen.propertymanagement.repository.PropertyRepository;
import com.naveen.propertymanagement.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceImplTest {

	@InjectMocks
	private PropertyServiceImpl propertyService;

	@Mock
	private PropertyRepository propertyRepository;
	@Mock
	private PropertyConverter propertyConverter;
	@Mock
	private UserRepository userRepository;

	@Test
	//@Disabled
	void savePropertyTest() {

		// PropertyDto to pass into the service save function
		PropertyDto propertyDto = new PropertyDto();
		propertyDto.setTitle("2BHK in kukatpally");
		propertyDto.setUserId(1L);
		propertyDto.setId(1L);

		// UserEntity to check if the user exists
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(1L);
		userEntity.setUserName("naveen");

		// PropertyEntity to return from converter
		PropertyEntity propertyEntity = new PropertyEntity();
		propertyEntity.setTitle("2BHK in kukatpally");
		propertyEntity.setUserEntity(userEntity);

		// Saved property to test
		PropertyEntity savedPropertyEntity = new PropertyEntity();
		savedPropertyEntity.setId(1L);
		savedPropertyEntity.setTitle("2BHK in kukatpally");
		savedPropertyEntity.setUserEntity(userEntity);

		Optional<PropertyEntity> propertyOptional = Optional.of(propertyEntity);
		Optional<UserEntity> userOptional = Optional.of(userEntity);

		when(userRepository.findById(Mockito.anyLong())).thenReturn(userOptional);
		when(propertyConverter.dtoToEntity(Mockito.any())).thenReturn(propertyEntity);
		when(propertyConverter.entityToDto(Mockito.any())).thenReturn(propertyDto);
		when(propertyRepository.save(Mockito.any())).thenReturn(savedPropertyEntity);

		PropertyDto actual = propertyService.saveProperty(propertyDto);

		Assertions.assertEquals(1L, actual.getId()); // Id is returning null

	}

	@Test
	//@Disabled
	void getProperty_success() {
		
		//PropertyDto to pass into the service save function
				PropertyDto propertyDto = new PropertyDto();
				propertyDto.setTitle("2BHK in kukatpally");
				propertyDto.setUserId(1L);
				
				//UserEntity to check if the user exists 
				UserEntity userEntity =  new UserEntity();
				userEntity.setUserId(1L);
				userEntity.setUserName("naveen");
				
				PropertyEntity savedPropertyEntity = new PropertyEntity();
				savedPropertyEntity.setId(1L);
				savedPropertyEntity.setTitle("2BHK in kukatpally");
				savedPropertyEntity.setUserEntity(userEntity);
				
				when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(savedPropertyEntity));
				when(propertyConverter.entityToDto(Mockito.any())).thenReturn(propertyDto);
				
				Assertions.assertEquals(1L, propertyService.getProperty(1L).getUserId());
				Assertions.assertEquals("2BHK in kukatpally", propertyService.getProperty(1L).getTitle());
		
		
	}
	
	@Test
	@DisplayName("Testing save property negative scenario")
	void savePropertyExceptionTest() {
		
		//PropertyDto to pass into the service save function
		PropertyDto propertyDto = new PropertyDto();
		propertyDto.setTitle("2BHK in kukatpally");
		propertyDto.setUserId(1L);
		
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		
		BusinessException thrownException = Assertions.assertThrows(BusinessException.class, ()->{
			PropertyDto savedPropertyDto = propertyService.saveProperty(propertyDto);
		});
		
		Assertions.assertEquals("USER_DOESNT_EXIST", thrownException.getErrors().get(0).getErrorCode());
		
	}

}
