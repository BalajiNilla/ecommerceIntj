package com.assignment.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.project.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
