package com.test.serviceImpl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.entity.Product;
import com.test.repository.ProductRepository;
import com.test.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repo;
	
	
	@Override
	public  Product addProduct(Product product)
	{
		return repo.save(product);
	}
	
	@Override
	public Product updateProduct(Product product)
	{
		Optional<Product> op = repo.findById(product.getId());
		
		if(op.isPresent())
		{
			return repo.save(product);
		}
		return null;
	}
	
	@Override
	public void deleteProduct(Product product)
	{
		Optional<Product> op = repo.findById(product.getId());
		
		if(op.isPresent())
		{
			repo.delete(op.get());
		}
		
	}
	

	@Override
	public List<Product> getProduct() {
		
		return repo.findAll();
	}
	

}
