package com.cg.capstore.service;

import com.cg.capstore.bean.OrderBean;
import com.cg.capstore.exception.OrderDetailsNotFoundException;

public interface IPlacingOrderService {

	OrderBean CheckProductAvailability(Integer id) throws OrderDetailsNotFoundException;
	OrderBean placingOrderOfProduct(OrderBean orderBean, String couponCode) throws OrderDetailsNotFoundException;
}
