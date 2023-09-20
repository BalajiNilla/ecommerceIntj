package com.assignment.project.contollers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.assignment.project.common.ApiResponse;
import com.assignment.project.models.Category;
import com.assignment.project.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryContoller {
	@Autowired CategoryService cs;

	@PostMapping("/create")
	
	public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
		cs.createCategory(category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true ," a new category"),HttpStatus.CREATED);
	}
	@GetMapping("/findall")
	
	public List<Category> findAll(){
		return cs.findll();
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ApiResponse> Delete(@PathVariable Integer Id) {
		if(!cs.findById(Id)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "cannot found the category"), HttpStatus.NOT_FOUND);
		}
		cs.Delete(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "category you want to delete is deleted  "), HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{Id}")
	 public ResponseEntity<ApiResponse> Update(@PathVariable Integer Id , @RequestBody Category category) {
		if(!cs.findById(Id)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "cannot found the category"), HttpStatus.NOT_FOUND);
		}
		
		cs.Update(Id,category);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated "), HttpStatus.OK);
				
	}
	
	
}
