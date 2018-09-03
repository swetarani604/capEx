package com.cg.capstore.service;

import com.cg.capstore.bean.OrderBean;
import com.cg.capstore.exception.ProductNotFoundException;

public interface IReturnGoodsService {
	OrderBean returnProduct(String id) throws ProductNotFoundException; 
	public String getDeliveryStatus (String orderId) throws ProductNotFoundException;
}
