package com.cg.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.bean.OrderBean;
import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.exception.OrderDetailsNotFoundException;
import com.cg.capstore.service.IPlacingOrderService;
import com.cg.capstore.service.IProductService;

@RestController
public class PlacingOrderController {
	
	@Autowired
	private IPlacingOrderService placingOrder;
	
	@Autowired
	private IProductService productService;
	
	
	@RequestMapping(value="/placingOrder",method=RequestMethod.POST)
	public String placingOrderFunctionality(@RequestBody OrderBean orderBean,String couponCode) throws OrderDetailsNotFoundException {
		try {
			placingOrder.placingOrderOfProduct(orderBean,couponCode);
		} catch (OrderDetailsNotFoundException e) {
			throw e;
		}
		System.out.println(couponCode);
		return orderBean.getOrderId()+" Order is Confirmed";
	}
	
	@RequestMapping(value="/finalizeOrder", method=RequestMethod.POST)
	public OrderBean checkProductAvailability(Integer id) throws OrderDetailsNotFoundException {
		
		try {
			return placingOrder.CheckProductAvailability(id);
		} catch (OrderDetailsNotFoundException e) {
			throw e;
		}
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public ProductBean addProduct(@RequestBody ProductBean product) {
		
		return productService.addProduct(product);
	}
	
	@RequestMapping(value="/findByProductId")
	public ProductBean findByProductId(String id) {
		return productService.findByProductId(id);
	}

}
