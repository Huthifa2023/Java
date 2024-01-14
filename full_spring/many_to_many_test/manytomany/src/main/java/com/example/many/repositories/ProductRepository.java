package com.example.many.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.many.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	Optional<Product> findProductByName(String name);
	List<Product> findByNameContaining(String infix);
	Product findProductById(Long productId);
}
