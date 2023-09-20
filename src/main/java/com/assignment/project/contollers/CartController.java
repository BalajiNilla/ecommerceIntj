package com.assignment.project.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.project.DTO.GetCartDto;
import com.assignment.project.DTO.cartDto;
import com.assignment.project.Exception.ProductNotexsistException;
import com.assignment.project.common.ApiResponse;
import com.assignment.project.models.AuthenticationToken;
import com.assignment.project.models.Cart;
import com.assignment.project.models.Product;
import com.assignment.project.models.User;
import com.assignment.project.services.AuthenticationService;
import com.assignment.project.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired CartService cartService;
	@Autowired AuthenticationService As;
	
	
	
	@PostMapping("/add")
	
	public ResponseEntity<ApiResponse> AddToCart(@RequestBody  cartDto cartDto,
			@RequestParam("token") String token) throws ProductNotexsistException{
		
		As.authenticate(token);
		
		User user = As.getUser(token);
		
		cartService.addtocart(cartDto,user);
		
		
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "added to the cart"), HttpStatus.OK);
		
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<GetCartDto> getCartItems(@RequestParam String token){
		
		As.authenticate(token);
		
		User user = As.getUser(token);
		
		GetCartDto cartItems = cartService.listItems(user);
		
		
		return new ResponseEntity<GetCartDto>(cartItems, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ApiResponse> DeleteCartItem(@PathVariable Integer Id,@RequestParam String token)
	{

		As.authenticate(token);
		
		User user = As.getUser(token);
		
		cartService.deleteCartItem(Id,user);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "item removed from the cart"), HttpStatus.OK);
	}
	@PutMapping("Update/")
	
	public  ResponseEntity<ApiResponse> update(@RequestBody cartDto cartdto,
			@RequestParam("token") String token) throws ProductNotexsistException{
		As.authenticate(token);
		User user = As.getUser(token);
		cartService.updateCartItem(cartdto.getProductId(),cartdto,user);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated to the cart"), HttpStatus.OK);
	}
}
