package com.assignment.project.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.project.DTO.ProductDto;
import com.assignment.project.common.ApiResponse;
import com.assignment.project.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired ProductService ps;
	
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto product){
		
		if(!ps.findCategoryById(product.getCategoryId())) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Category is not found"),HttpStatus.BAD_REQUEST);
		}
		
		ps.CreateProduct(product);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse(true ," a new product is added "),HttpStatus.CREATED);
		
	}
	@GetMapping("/findall")
	public ResponseEntity<List<ProductDto>> findAll(){
		
		List<ProductDto> allproducts = ps.findAll();
		
		
		return new ResponseEntity<List<ProductDto>>(allproducts,HttpStatus.OK);
	}
	
	@PutMapping("/update/{Id}")
	
	public ResponseEntity<ApiResponse> updateProduct(@PathVariable Integer Id , @RequestBody ProductDto productdto){
		
		try {
			ps.updateProduct(Id,productdto);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true ," the product is updated"),HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<ApiResponse>(new ApiResponse(true ," product you are looking is not present "),HttpStatus.NOT_FOUND);
		}
	}
}
