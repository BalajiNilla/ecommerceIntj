package com.assignment.project.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.project.DTO.ProductDto;
import com.assignment.project.Exception.ProductNotexsistException;
import com.assignment.project.Repositories.CategoryRepository;
import com.assignment.project.Repositories.ProductRepository;
import com.assignment.project.models.Product;

@Service
public class ProductService {
	
	@Autowired ProductRepository pr;
	
	@Autowired CategoryRepository cr;
	
	public boolean findCategoryById(Integer id) {
		// TODO Auto-generated method stub
		return cr.existsById(id);
	}

	public void CreateProduct(ProductDto productdto) {
		// TODO Auto-generated method stub
		Product product = new Product();
		
		product.setName(productdto.getName());
		product.setImageurl(productdto.getImageurl());
		product.setDiscrption(productdto.getDiscrption());
		product.setPrice(productdto.getPrice());
		product.setCategory(cr.findById(productdto.getCategoryId()).get());
		pr.save(product);
	}
	
	public static ProductDto getProductDto(Product product) {
		ProductDto productdto = new ProductDto();
		productdto.setId(product.getId());
		productdto.setName(product.getName());
		productdto.setDiscrption(product.getDiscrption());
		productdto.setImageurl(product.getImageurl());
		productdto.setPrice(product.getPrice());
		productdto.setCategoryId(product.getCategory().getId());
		return productdto;
	}

	public List<ProductDto> findAll() {
		List<Product> AllProducts = pr.findAll();
		
		List<ProductDto> allproducts = new ArrayList();
		
		for(Product product : AllProducts ) {
			allproducts.add(getProductDto(product));
		}
		return allproducts;
		
		
		
	}

	public void updateProduct(Integer id, ProductDto productdto) throws Exception {
		// TODO Auto-generated method stub
		
		if(!pr.findById(id).isPresent()) {
			throw new ProductNotexsistException("Product is not present");
		}
		
		Product product = pr.findById(id).get();
		product.setName(productdto.getName());
		product.setImageurl(productdto.getImageurl());
		product.setDiscrption(productdto.getDiscrption());
		product.setPrice(productdto.getPrice());
		pr.save(product);
		
		
	}

	public Product findById(Integer productId) throws ProductNotexsistException {
		Optional<Product> products=	pr.findById(productId);
		
		if(products.isEmpty()) {
			throw new ProductNotexsistException("Product is invalid: "+productId);
		}
		
		
		
		return pr.findById(productId).get();
		
	}
	
	

}
