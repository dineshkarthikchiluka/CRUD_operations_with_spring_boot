package com.dk.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dk.crud.example.entity.Product;
import com.dk.crud.example.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
	}
	
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/product/{id}")
	public Product findProductById(@PathVariable int id){ // you can also use @requestparameter also for passing a parameter. If you use pathvariable you have to include the field in url if not you get 404 error.
		return service.getProductById(id);
	}
	
	@GetMapping("/product/name/{name}")
	public Product findProductByName(@PathVariable String name){
		return service.getProductByName(name);
	}
	
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
	
}
