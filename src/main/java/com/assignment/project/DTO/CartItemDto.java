package com.assignment.project.DTO;

import com.assignment.project.models.Cart;
import com.assignment.project.models.Product;

//details of the product and quantity in the cart

public class CartItemDto {
	
	private Integer id;
	
	private Integer quantity;
	
	private Product product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CartItemDto(Integer id, Integer quantity, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
	}

	public CartItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CartItemDto(Cart cart) {
		
		this.id=cart.getId();
		this.quantity=cart.getQuantity();
		this.setProduct(cart.getProduct());
	}

}
