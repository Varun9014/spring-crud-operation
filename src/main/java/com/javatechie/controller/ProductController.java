package com.javatechie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.entity.Product;
import com.javatechie.service.ProductService;


@RestController
public class ProductController
{

	@Autowired
	private ProductService service;
	
	//----------------2
	@PostMapping("/addproduct")
	public Product aProduct(@RequestBody Product product)
	{
		return service.saveProduct(product);
	}
	
	@PostMapping("/addproducts")
	public List<Product> aProducts(@RequestBody List<Product> products)
	{
		return service.saveProducts(products);
	}
	
	
	//------------------3
	@GetMapping("/getbyid/{id}")
	public Product gProductById(@PathVariable int id)
	{
		return service.getProductById(id);
	}
	
	@GetMapping("/getbyname/{name}")
	public Product gProductByName(@PathVariable String name)
	{
		return service.getProductByName(name);
	}
	
	@GetMapping("/getallproduct")
	public List<Product> gAllProduct( )
	{
		
		 return service.getAllProduct();
		
	}
	
	// ------------------1
	@DeleteMapping("/deleteproductbyid/{id}")
	public String dProductById(@PathVariable int id)
	{
		service.deleteProductById(id);
		return " ";
	}
	// -------------------1
	@PutMapping("/updateproduct")
	public Product uProduct(@RequestBody Product product)
	{
		return service.updateProduct(product);
		
	}
		
}
