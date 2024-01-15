package com.example.many.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.many.models.Category;
import com.example.many.models.Product;
import com.example.many.services.CategoryService;
import com.example.many.services.ProductService;

import jakarta.validation.Valid;


@Controller
public class MainController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("products", productService.allProducts());
		model.addAttribute("categories", categoryService.allCategories());
		return "home.jsp";
	}
	
	@GetMapping("/products/new")
	public String newproduct(@ModelAttribute("newProduct") Product newProduct) {
		return "newproduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String newproduct(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result) {
		if(result.hasErrors()) {
			return "newproduct.jsp";
		}
		productService.createProduct(newProduct);
		return "redirect:/";
	}
	
	@GetMapping("/categories/new")
	public String newcategory(@ModelAttribute("newCategory") Category newCategory) {
		return "newcategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String newcategory(@Valid @ModelAttribute("newCategory") Category newCategory, BindingResult result) {
		if(result.hasErrors()) {
			return "newcategory.jsp";
		}
		categoryService.createCategory(newCategory);
		return "redirect:/";
	}
	
	@GetMapping("/products/{productId}")
	public String product(@PathVariable("productId") Long productId, Model model,
			@ModelAttribute("newCategory") Category newCategory) {
		model.addAttribute("product", productService.findProductById(productId));
		List<Category> categoriesToAdd = categoryService.findByProductsNotContains(productService.findProductById(productId));
		model.addAttribute("categoriesToAdd", categoriesToAdd);
		return "product.jsp";
	}
	
	@PostMapping("/products/{productId}")
	public String product(@PathVariable("productId") Long productId,
			@ModelAttribute("newCategory") Category newCategory) {
		Category catToAdd = categoryService.findCategoryById(newCategory.getId());
		productService.addToCategory(catToAdd, productService.findProductById(productId));
		return "redirect:/products/"+productId;
	}
	
	@GetMapping("/categories/{categoryId}")
	public String category(@PathVariable("categoryId") Long categoryId,Model model,
			@ModelAttribute("newProduct") Product newProduct) {
		model.addAttribute("category", categoryService.findCategoryById(categoryId));
		List<Product> productsToAdd = productService.findByCategoriesNotContains(categoryService.findCategoryById(categoryId));
		model.addAttribute("productsToAdd", productsToAdd);
		return "category.jsp";
	}
	
	@PostMapping("/categories/{categoryId}")
	public String category(@PathVariable("categoryId") Long categoryId, @ModelAttribute("newProduct") Product newProduct,
			BindingResult result) {
		categoryService.addToProduct(categoryService.findCategoryById(categoryId), productService.findProductById(newProduct.getId()));
		return "redirect:/categories/"+categoryId;
	}
	
}
