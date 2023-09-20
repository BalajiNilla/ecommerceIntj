package com.assignment.project.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.project.DTO.CartItemDto;
import com.assignment.project.DTO.GetCartDto;
import com.assignment.project.DTO.cartDto;
import com.assignment.project.Exception.CustomException;
import com.assignment.project.Exception.ProductNotexsistException;
import com.assignment.project.Repositories.CartRepository;
import com.assignment.project.models.Cart;
import com.assignment.project.models.Product;
import com.assignment.project.models.User;
@Service
public class CartService {
	@Autowired CartRepository cartRepository;
	
	@Autowired ProductService productService;

	public void addtocart(cartDto cartDto, User user) throws ProductNotexsistException {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		Integer quantity= 0;
		Product product=productService.findById(cartDto.getProductId());
		
		if(Objects.nonNull(cartRepository.findByProduct(product))) {
			 cart = cartRepository.findByProduct(product);
			quantity=cart.getQuantity();			
		}
		cart.setProduct(product);
		
		cart.setUser(user);
		
		cart.setQuantity(cartDto.getQuantity()+quantity);
		
		cart.setCreatedDate(new Date());
		
		cartRepository.save(cart);
	}
	public GetCartDto listItems(User user) {
		
		List<Cart> cartList = cartRepository.findAllByUser(user);
		List<CartItemDto> cartItems = new ArrayList<>();
		double totalcost =0;
		for(Cart cart: cartList) {
			CartItemDto cartitemDto = new  CartItemDto(cart);
			totalcost+=cartitemDto.getQuantity()*cart.getProduct().getPrice();
			cartItems.add(cartitemDto);
		}
		
		GetCartDto finalcartDto = new GetCartDto();
		finalcartDto.setTotalCost(totalcost);
		finalcartDto.setCartItems(cartItems);
		
		return finalcartDto;
	}

	public  void deleteCartItem(Integer id, User user) {
		
		Optional<Cart> optionalCart =cartRepository.findById(id);
		if(optionalCart.isEmpty()) {
			throw new CustomException("Item Id is invalid :"+id);
		}
		
		Cart cart = optionalCart.get();
		
		if(cart.getUser()!=user) {
			throw new CustomException("Cart item does not belong to you Mr.:"+user.getFirstName());
			
		}
		cartRepository.deleteById(id);
	}
	public void updateCartItem(Integer productId, cartDto cartdto, User user) throws ProductNotexsistException {
		// TODO Auto-generated method stub
		Product product=productService.findById(cartdto.getProductId());
		
		Cart cart = cartRepository.findByProduct(product);

		cart.setProduct(product);
		
		cart.setUser(user);
		
		cart.setQuantity(cartdto.getQuantity());
		
		cart.setCreatedDate(new Date());
		
		cartRepository.save(cart);
	}
	

	
}
