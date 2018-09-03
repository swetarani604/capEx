package com.cg.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.exception.CategoryNotFoundException;
import com.cg.capstore.exception.ProductNotFoundException;
import com.cg.capstore.service.IManagingInventoryService;




@RestController
public class ManagingInventoryController {
	
	@Autowired
	IManagingInventoryService managingInventoryService;
	
	
	@RequestMapping(value = "/displayAllProducts",method=RequestMethod.POST)
	List<ProductBean> displayAllProducts() throws ProductNotFoundException {
		
		try {
			return managingInventoryService.displayAllProducts();
		} catch (ProductNotFoundException e) {
			throw e;
		}
		
	}
	
	@RequestMapping(value = "/addNewProduct", method = RequestMethod.POST)
	ProductBean addNewProduct(@RequestBody ProductBean product) throws ProductNotFoundException  {
		try {
			return managingInventoryService.addNewProduct(product);
		} catch (ProductNotFoundException e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/updateProductDetails",method=RequestMethod.PUT)
	public ProductBean updateProductDetails(@RequestBody ProductBean product) throws ProductNotFoundException {
		
		try {
			return managingInventoryService.updateProductDetails(product);
		} catch (ProductNotFoundException e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/deleteProduct",method=RequestMethod.DELETE)
	public String deleteProduct(String productId) throws ProductNotFoundException {
		
		try {
			return managingInventoryService.deleteProduct(productId);
		} catch (ProductNotFoundException e) {
			throw e;
		}
	}
	
	
	
	@RequestMapping(value = "/getProductdetailsById",method=RequestMethod.POST)
	public ProductBean getProductdetails(String productId) throws ProductNotFoundException {
		
		try {
			return managingInventoryService.getProductdetailsById(productId);
		} catch (ProductNotFoundException e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/removeExistingCategory",method=RequestMethod.DELETE)
	public String removeExistingCategory(String category) throws CategoryNotFoundException {
		
		try {
			return managingInventoryService.removeExistingCategory(category);
		} catch (CategoryNotFoundException e) {
			throw e;
		}
	}
	
	@RequestMapping(value="/displayAllCategory", method=RequestMethod.POST)
	public List<ProductBean> displayAllCategory(String category) throws CategoryNotFoundException {
		try {
			return managingInventoryService.displayAllCategory();
		} catch (CategoryNotFoundException e) {
			throw e;
		}
	}
	
}