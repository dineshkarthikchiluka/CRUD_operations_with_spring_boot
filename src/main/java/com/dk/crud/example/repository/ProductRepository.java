package com.dk.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.crud.example.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);
	
}
