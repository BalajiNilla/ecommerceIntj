package com.assignment.project.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.project.models.Cart;
import com.assignment.project.models.Product;
import com.assignment.project.models.User;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	List<Cart> findAllByUser(User user);
	
	Cart findByProduct(Product product);
}
