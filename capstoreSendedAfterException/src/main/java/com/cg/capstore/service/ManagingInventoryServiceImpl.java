package com.cg.capstore.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.exception.CategoryNotFoundException;
import com.cg.capstore.exception.ProductNotFoundException;
import com.cg.capstore.repo.ProductRepo;
@Service
public class ManagingInventoryServiceImpl implements IManagingInventoryService{
	@Autowired
	ProductRepo productRepo;
	
	@Override
	public List<ProductBean> displayAllProducts() throws ProductNotFoundException {
		if(ProductBean.class == null) {
			throw new ProductNotFoundException("Inventory is empty");
		}
		return productRepo.findAll();
	}
	@Override
	public ProductBean addNewProduct(ProductBean product) throws ProductNotFoundException {
		if(product.getProductId()!=null) {
			throw new ProductNotFoundException("Product Id should have valid credential ");
		}
		return productRepo.save(product);
	}
	@Override
	public ProductBean updateProductDetails(ProductBean product) throws ProductNotFoundException {
		
		ProductBean product1= productRepo.getOne(product.getProductId());
		if(product1.getProductId()==null) {
			throw new ProductNotFoundException("Product is not available");
		}else {
			
		
		product1.setProductName(product.getProductName());
		product1.setCategory(product.getCategory());
		product1.setDiscount(product.getDiscount());
		product1.setProductId(product.getProductId());
		product1.setPrice(product.getPrice());
		product1.setQuantity(product.getQuantity());
		product1.setImageId(product.getImageId());
		return productRepo.save(product1);
		}
	}
	@Override
	public String deleteProduct(String productId) throws ProductNotFoundException {
		productRepo.getOne(productId);
		if(productId==null) {
			throw new ProductNotFoundException("Product is not available");
		}else {
			
		productRepo.deleteById(productId);
		
		return productId;
		}
		}
	@Override
	public ProductBean getProductdetailsById(String productId) throws ProductNotFoundException {
		if(productId==null) {
			throw new ProductNotFoundException("Product is not available");
		}else {
		return productRepo.getOne(productId);
	}
	}
	
	
	@Override
	public String removeExistingCategory(String categoryId) throws CategoryNotFoundException {
		if(categoryId==null) {
			throw new CategoryNotFoundException("Category is not available");
		}else {
		productRepo.deleteById(categoryId);
		return categoryId+" category is deleted";
		}
	}
	@Override
	public List<ProductBean> displayAllCategory() throws CategoryNotFoundException {
		if(ProductBean.class==null) {
			throw new CategoryNotFoundException("Inventory with category is empty");
		}
		return productRepo.getSimilarCategory();
	}
	
	
	
}
