package com.cg.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.repo.ProductRepo;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductRepo repo;

	@Override
	public ProductBean addProduct(ProductBean product) {
		
		return repo.save(product);
	}

	@Override
	public ProductBean findByProductId(String productId) {
		
		return repo.getOne(productId);
	}
	
	
	

}
