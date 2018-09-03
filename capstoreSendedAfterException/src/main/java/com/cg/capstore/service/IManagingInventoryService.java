package com.cg.capstore.service;

import java.util.List;

import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.exception.CategoryNotFoundException;
import com.cg.capstore.exception.ProductNotFoundException;

public interface IManagingInventoryService {
	List<ProductBean> displayAllProducts() throws ProductNotFoundException;
	ProductBean addNewProduct(ProductBean product) throws ProductNotFoundException;
	ProductBean updateProductDetails(ProductBean product) throws ProductNotFoundException;
	String deleteProduct(String productId) throws ProductNotFoundException;
	
	
	ProductBean getProductdetailsById(String productId) throws ProductNotFoundException;
	
	
	public List<ProductBean> displayAllCategory() throws CategoryNotFoundException;
	public String removeExistingCategory(String category) throws CategoryNotFoundException;
}
