package com.assignment.project.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.project.models.Product;
import com.assignment.project.models.Wishlist;

public interface WishlistRepository extends  JpaRepository<Wishlist, Integer>{
	Wishlist findByProduct(Product product);
	
	List<Wishlist> findAllByUserId(Integer userId);
}
