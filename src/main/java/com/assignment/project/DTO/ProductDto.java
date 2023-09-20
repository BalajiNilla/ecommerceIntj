package com.assignment.project.DTO;

import jakarta.annotation.Nonnull;

public class ProductDto {
	
	private @Nonnull Integer Id;
	
	private @Nonnull String name;
	
	
	private @Nonnull String imageurl;
	
	
	private@Nonnull String discrption;
	
	
	private @Nonnull double price;
	
	private @Nonnull Integer categoryId;

	public String getName() {
		return name;
	}

	public ProductDto() {
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getDiscrption() {
		return discrption;
	}

	public void setDiscrption(String discrption) {
		this.discrption = discrption;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	
}
