package com.naveen.propertymanagement.dto;

import com.naveen.propertymanagement.entity.UserEntity;

public class PropertyDto {
	
	private Long id;
	private String title;
	private Long userId;
	private String description;
	private Double price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public PropertyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PropertyDto [id=" + id + ", title=" + title + ", userId=" + userId + ", description=" + description
				+ ", price=" + price + "]";
	}
	
	

}
