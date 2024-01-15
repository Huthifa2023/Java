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
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	public void addToCategory(Category category, Product product) {
		product.getCategories().add(category);
		productRepository.save(product);
	}
	
	public Product findProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}
	
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	
	public void createProduct(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> findByCategoriesNotContains(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}
	
	
}
