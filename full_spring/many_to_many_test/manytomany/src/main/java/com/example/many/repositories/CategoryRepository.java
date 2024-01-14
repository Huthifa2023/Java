package com.example.many.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.many.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	Optional<Category> findCategoryByName(String name);
	List<Category> findByNameContaining(String infix);
	Category findCategoryById(Long categoryId);
}
