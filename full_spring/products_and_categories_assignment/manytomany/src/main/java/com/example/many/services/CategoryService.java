package com.example.many.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.many.models.Category;
import com.example.many.models.Product;
import com.example.many.repositories.CategoryRepository;
import com.example.many.repositories.ProductRepository;

@Service
public class CategoryService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	public void addToProduct(Category category, Product product) {
		category.getProducts().add(product);
		categoryRepository.save(category);
	}
	
	public Category findCategoryById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.get();
	}
	
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public List<Category> findByProductsNotContains(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
	
}

