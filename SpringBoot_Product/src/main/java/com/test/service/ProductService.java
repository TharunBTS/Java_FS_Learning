package com.test.service;


import java.util.List;

import com.test.entity.Product;

public interface ProductService {
	
	Product addProduct(Product product);
	Product updateProduct(Product product);
	void deleteProduct(Product product);
	List<Product> getProduct();

}
