package com.cg.capstore.service;

import com.cg.capstore.bean.ProductBean;

public interface IProductService {
	
	public ProductBean addProduct(ProductBean product)  ;
	
	public ProductBean findByProductId(String productId);

}
