package com.assignment.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.project.models.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
