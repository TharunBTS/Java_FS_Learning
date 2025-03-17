package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Product;
import com.test.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@PostMapping("/add")
	public  ResponseEntity<Product> adding(@RequestBody Product product)
	{
		Product obj = ps.addProduct(product);
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
		
	}
	@PutMapping("/update")
	public Product updating(@RequestBody Product product)
	{
		return ps.updateProduct(product);
		
	}
	@DeleteMapping("/delete")
	public void deleting(@RequestBody Product product)
	{
		ps.deleteProduct(product);
		
	}
	@GetMapping("/get")
	public List<Product> getting(@RequestBody Product product)
	{
		return ps.getProduct();
		
	}

}
