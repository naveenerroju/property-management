package com.naveen.propertymanagement.service;

import java.util.List;

import com.naveen.propertymanagement.dto.PropertyDto;

public interface PropertyService {
	
	public PropertyDto saveProperty(PropertyDto property);
	public PropertyDto getProperty(Long id);
	public List<PropertyDto> getAllProperty();
	public PropertyDto updateProperty(Long id, PropertyDto property);
	public PropertyDto updateDescProperty(Long id, String desc);

}
