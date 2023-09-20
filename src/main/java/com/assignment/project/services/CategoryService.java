package com.assignment.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.project.Repositories.CategoryRepository;
import com.assignment.project.models.Category;

@Service

public class CategoryService {

	@Autowired CategoryRepository cr;
	
	
	public void createCategory(Category category) {
		cr.save(category);
	}
	
	
	public List<Category> findll(){
		return cr.findAll();
	}
	
	public void Delete(Integer Id) {
		cr.deleteById(Id);
		
	}


	public void Update(Integer id, Category updatedcategory) {
		
		Category category = cr.findById(id).get();
		category.setImageUrl(updatedcategory.getImageUrl());
		category.setName(updatedcategory.getName());
		cr.save(category);
		
		
		// TODO Auto-generated method stub
		
	}


	public boolean findById(Integer id) {
		// TODO Auto-generated method stub
		return cr.existsById(id);
	}
}
