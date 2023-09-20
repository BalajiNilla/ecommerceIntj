package com.assignment.project.DTO;

import java.util.List;
// to get the cart items 

public class GetCartDto {
	
	List<CartItemDto> cartItems ;
	
	private double totalCost;

	public List<CartItemDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemDto> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public GetCartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetCartDto(List<CartItemDto> cartItems, double totalCost) {
		super();
		this.cartItems = cartItems;
		this.totalCost = totalCost;
	}
	
	

}
