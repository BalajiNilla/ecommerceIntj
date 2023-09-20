package com.assignment.project.DTO;

import io.micrometer.common.lang.NonNull;

//for creating the cart item
public class cartDto {
	
	private Integer Id;
	
	private @NonNull Integer productId;
	
	private @NonNull Integer quantity;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	

}
