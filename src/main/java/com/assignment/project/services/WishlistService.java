package com.assignment.project.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.project.DTO.ProductDto;
import com.assignment.project.Exception.AuthenticationfailedException;
import com.assignment.project.Repositories.WishlistRepository;
import com.assignment.project.models.User;
import com.assignment.project.models.Wishlist;

@Service
public class WishlistService {
	
	@Autowired WishlistRepository wishlistRepository;
	@Autowired ProductService ps;
	

	public void addtoWishlist(Wishlist wishlist) {
		// TODO Auto-generated method stub
//		if(Objects.nonNull(wishlistRepository.findByProduct(wishlist.getProduct()))) {
//			throw new AuthenticationfailedException("Product is already present in the wishlist");
//		}
		List<Wishlist>wishlists=wishlistRepository.findAllByUserId(wishlist.getUser().getId());
		List<Integer> productIds = new ArrayList<>();
		for(Wishlist list: wishlists) {
			productIds.add(list.getProduct().getId());
		}
		if(!productIds.contains(wishlist.getProduct().getId())){
			wishlistRepository.save(wishlist);	
		}
		else {
			throw new AuthenticationfailedException("product is already present in the wishlist");
		}
			
	}
	
	public List<ProductDto> findAll(User user){
 
		List<Wishlist>wishlist=wishlistRepository.findAllByUserId(user.getId());
		
		List<ProductDto> products = new ArrayList<>();
		for(Wishlist list:wishlist) {
			
			products.add(ps.getProductDto(list.getProduct()));
		}
		
		return products;
		

}
}
