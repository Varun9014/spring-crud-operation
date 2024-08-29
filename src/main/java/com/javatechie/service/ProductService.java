package com.javatechie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.entity.Product;
import com.javatechie.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository repository;
	//------------------------ save one row 
	public Product saveProduct(Product product)
	{
		return repository.save(product);
	}
	
	 
	// save more products
	public List<Product> saveProducts(List<Product> products)
	{
		return repository.saveAll(products);
	}
	
	
	
	// ------------------------- get all row 3
	public List<Product> getAllProduct()
	{
		 return  repository.findAll();
		
	}
	
	
	
	// get product by id
	public Product getProductById(int id)
	{
		return repository.findById(id).orElse(null);
		
	}
	
	
	
	// get product by name
	public Product getProductByName(String name)
	{
		return repository.findByName(name);
	}
	
	
	
	// delete product By Id
	public String deleteProductById(int id)
	{
		repository.deleteById(id);
		return "product removed"+id;
		
				
	}
	
	
	
	// update the product by id
	public Product updateProduct(Product product)
	{
		Product existingProduct= repository.findById(product.getId()).orElse(product);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}
	
}
