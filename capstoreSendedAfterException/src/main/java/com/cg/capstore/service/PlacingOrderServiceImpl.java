package com.cg.capstore.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.bean.CouponsBean;
import com.cg.capstore.bean.OrderBean;
import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.exception.OrderDetailsNotFoundException;
import com.cg.capstore.repo.CouponRepo;
import com.cg.capstore.repo.PlacingOrdersRepo;

@Service
public class PlacingOrderServiceImpl implements IPlacingOrderService {

	@Autowired
	private PlacingOrdersRepo placingOrderRepo;
	
	@Autowired
	private CouponRepo repo;
	
	@Override
	public OrderBean placingOrderOfProduct(OrderBean orderBean,String couponCode) throws OrderDetailsNotFoundException {
		if(orderBean.getOrderId()== null) {
			throw new OrderDetailsNotFoundException("Product is not available");
		}
		
		else {
		if(orderBean.getMinBillingAmount()<orderBean.getTotalPrice()) {
		double price=applyCoupons(couponCode, orderBean.getTotalPrice());
		orderBean.setTotalPrice(price);
		}
		
		return placingOrderRepo.save(orderBean);
	}}
	
	private Double applyCoupons(String couponCode,Double price)
	{
		CouponsBean coupon1=repo.getCouponDetails(couponCode);
		LocalDate startDate=coupon1.getStartDate().toLocalDate();
		LocalDate endDate=coupon1.getEndDate().toLocalDate();
		Double totalPrice=0.0;
		if(coupon1.getCouponCode().equals(couponCode)&&startDate.isBefore(LocalDate.now())&&endDate.isAfter(LocalDate.now()))
		{
			totalPrice=price-((price*coupon1.getCouponAmount())/100);
		}
			return totalPrice;
	}

	@Override
	public OrderBean CheckProductAvailability(Integer id) throws OrderDetailsNotFoundException {
		
	 OrderBean orderBean= placingOrderRepo.getOne(id);
	 if(orderBean.getOrderId()== null) {
		 throw new OrderDetailsNotFoundException("Product is not available");
	 }
	 else {
	 
	 if(orderBean.getOrderStatus().equalsIgnoreCase("Order is Confirmed")) {
		 
		 List<ProductBean> placingOrder = orderBean.getProduct();
		 
		 for (ProductBean productBean : placingOrder) {
			 orderBean.getQuantity();
			
			 int quantity = productBean.getQuantity() - orderBean.getQuantity();
			 productBean.setQuantity(quantity);
			 
		}
	 }
	 return placingOrderRepo.save(orderBean);
	 }	
	}

}
