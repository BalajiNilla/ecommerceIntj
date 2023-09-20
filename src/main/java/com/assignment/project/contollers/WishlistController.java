package com.assignment.project.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.project.DTO.ProductDto;
import com.assignment.project.common.ApiResponse;
import com.assignment.project.models.Product;
import com.assignment.project.models.User;
import com.assignment.project.models.Wishlist;
import com.assignment.project.services.AuthenticationService;
import com.assignment.project.services.WishlistService;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
	
	@Autowired WishlistService wishlistService;
	
	@Autowired AuthenticationService as;
	
	
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> AddtoWishlist(@RequestBody Product product,
			@RequestParam("token") String token){
		System.out.println(token);
		
		as.authenticate(token);
		
		User user = as.getUser(token);
		
		Wishlist wishlist = new Wishlist(user, product);
		
		wishlistService.addtoWishlist(wishlist);
		
		
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product added to the wishlist"), HttpStatus.CREATED);
	}
	
	@GetMapping("/findall")
	public ResponseEntity<List<ProductDto>> findAll(@RequestParam String token){
		as.authenticate(token);
		User user = as.getUser(token);
		
		List<ProductDto> wishlist = wishlistService.findAll(user);
		
		return new ResponseEntity<List<ProductDto>>(wishlist,HttpStatus.OK);
				
		
	}
	

}
