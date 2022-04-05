package com.mmustafa.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mmustafa.northwind.business.abstracts.ProductService;
import com.mmustafa.northwind.core.utilities.results.DataResult;
import com.mmustafa.northwind.core.utilities.results.Result;
import com.mmustafa.northwind.entities.concretes.Product;
import com.mmustafa.northwind.entities.dtos.ProductWithCategoryDto;

@RestControllerAdvice
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}


	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName , @RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName , @RequestParam int categoryId){
		return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
	}
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo , int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	

	
}
