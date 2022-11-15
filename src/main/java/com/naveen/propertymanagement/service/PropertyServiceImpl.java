package com.naveen.propertymanagement.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Error;
import org.springframework.stereotype.Service;

import com.naveen.propertymanagement.converter.PropertyConverter;
import com.naveen.propertymanagement.dto.PropertyDto;
import com.naveen.propertymanagement.entity.PropertyEntity;
import com.naveen.propertymanagement.entity.UserEntity;
import com.naveen.propertymanagement.excepetion.BusinessException;
import com.naveen.propertymanagement.excepetion.ErrorModel;
import com.naveen.propertymanagement.repository.PropertyRepository;
import com.naveen.propertymanagement.repository.UserRepository;

@Service
public class PropertyServiceImpl implements PropertyService{
	
	
	@Autowired private PropertyRepository repository;
	@Autowired private PropertyConverter converter;
	@Autowired private UserRepository userRepository;

	@Override
	public PropertyDto saveProperty(PropertyDto property) {
		
		Optional<UserEntity> o = userRepository.findById(property.getUserId());
		
		if(o.isEmpty()) {
			
			ErrorModel error = new ErrorModel();
			error.setErrorCode("USER_DOESNT_EXIST");
			error.setErrorMessage("The User id you are trying to provide, doesn't exist in database.");
			
			List<ErrorModel> errors = new ArrayList<ErrorModel>();
			errors.add(error);
			
			throw new BusinessException(errors);
			
		} else {
			
			PropertyEntity entity = converter.dtoToEntity(property);
			entity.setUserEntity(o.get());
			repository.save(entity);
			
			PropertyDto dto = converter.entityToDto(entity);
			return dto;
		}
		
	}

	@Override
	public PropertyDto getProperty(Long id) {
		Optional<PropertyEntity> o = repository.findById(id);
		if (o.isEmpty()) {
			ErrorModel error = new ErrorModel();
			error.setErrorCode("PROPERTY_ID_DOESNT_EXIST");
			error.setErrorMessage("The Id you are trying to update, doesn't exist in database.");
			
			List<ErrorModel> errors = new ArrayList<ErrorModel>();
			errors.add(error);
			
			throw new BusinessException(errors);
		} else {
			return converter.entityToDto(o.get());
		}
	}

	@Override
	public List<PropertyDto> getAllProperty() {
		
		List<PropertyEntity> data = (List<PropertyEntity>)(repository.findAll());
		List<PropertyDto> convertedData = new ArrayList<PropertyDto>();
		
		for (PropertyEntity propertyEntity : data) {
			PropertyDto dto = converter.entityToDto(propertyEntity);
			convertedData.add(dto);
		}
		
		
		return convertedData;
	}

	@Override
	public PropertyDto updateProperty(Long id, PropertyDto property) {
		
		PropertyEntity entity = converter.dtoToEntity(property);
		Optional<PropertyEntity> o = repository.findById(id);
		
		if(o.isEmpty()) {
			ErrorModel error = new ErrorModel();
			error.setErrorCode("PROPERTY_ID_DOESNT_EXIST");
			error.setErrorMessage("The Id you are trying to update, doesn't exist in database.");
			
			List<ErrorModel> errors = new ArrayList<ErrorModel>();
			errors.add(error);
			
			throw new BusinessException(errors);
		} else {
			return converter.entityToDto(repository.save(entity));
		}

	}

	@Override
	public PropertyDto updateDescProperty(Long id, String desc) {
		
		Optional<PropertyEntity> o = repository.findById(id);
		
		if(o.isEmpty()) {
			ErrorModel error = new ErrorModel();
			error.setErrorCode("PROPERTY_ID_DOESNT_EXIST");
			error.setErrorMessage("The Id you are trying to update, doesn't exist in database.");
			
			List<ErrorModel> errors = new ArrayList<ErrorModel>();
			errors.add(error);
			
			throw new BusinessException(errors);
		} else {
			PropertyEntity entity = o.get();
			entity.setDescription(desc);
			return converter.entityToDto(repository.save(entity));
		}
	}

}
