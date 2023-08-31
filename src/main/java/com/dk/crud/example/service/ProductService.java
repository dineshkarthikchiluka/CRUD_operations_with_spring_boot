package com.dk.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dk.crud.example.entity.Product;
import com.dk.crud.example.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	// post method for single product
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	// post method for a list of products
	public List<Product> saveProducts(List<Product> products){
		return repository.saveAll(products);
	}
	
	// get method 
	public List<Product> getProducts(){
		return repository.findAll();
	}
		
	// get method by id
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null); // it will return optional if it not get any value then it returns null.
	}
		
	// get method by name
	public Product getProductByName(String name) {
		return repository.findByName(name); 
	}
	
	// delete method
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product Removed !! " + id; 
	}
	
//	public Product updateProduct(Product product) {
//		Product existingProduct = repository.findById(product.getId()).orElse(null);
//		existingProduct.setName(product.getName());
//		existingProduct.setQuantity(product.getQuantity());
//		existingProduct.setPrice(product.getPrice());
//		return repository.save(existingProduct);
//	}
	public Product updateProduct(Product product) {
	    // Retrieve the existing product with the given ID from the repository
	    Product existingProduct = repository.findById(product.getId()).orElse(null);

	    // Check if the existing product with the given ID exists
	    if (existingProduct != null) {
	        // Update the properties of the existing product with the new values from the provided product
	        existingProduct.setName(product.getName());
	        existingProduct.setQuantity(product.getQuantity());
	        existingProduct.setPrice(product.getPrice());

	        // Save the updated product back to the repository and return the updated product
	        return repository.save(existingProduct);
	    } else {
	        // If the product with the given ID doesn't exist, return null or throw an exception, depending on your use case
	        return null; // You can customize this behavior as needed
	    }
	}
	
	
	
}
