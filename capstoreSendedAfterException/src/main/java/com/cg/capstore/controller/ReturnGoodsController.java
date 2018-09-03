package com.cg.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.bean.OrderBean;
import com.cg.capstore.exception.ProductNotFoundException;
import com.cg.capstore.service.IReturnGoodsService;

@RestController
public class ReturnGoodsController {

	@Autowired
	IReturnGoodsService returnGoodsService;
	
	@RequestMapping(value="/returnPurchasedProduct", method=RequestMethod.POST)
	public OrderBean returnProduct(String id) throws ProductNotFoundException {
		
		
			try {
				return returnGoodsService.returnProduct(id);
			} catch (ProductNotFoundException e) {
				throw e;
			}
		
	}
	
	@RequestMapping(value="/getDeliveryStatus", method=RequestMethod.GET)
	public String getDeliveryStatus(String orderId) throws ProductNotFoundException {
		
		try {
			return returnGoodsService.getDeliveryStatus(orderId);
		} catch (ProductNotFoundException e) {
			throw e;
		}
		
	}
}
