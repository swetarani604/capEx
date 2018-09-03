package com.cg.capstore.service;

import java.util.List;

import com.cg.capstore.bean.DiscountBean;
import com.cg.capstore.exception.DiscountDateExceedException; 

public interface ApplyDiscountInterface {

	DiscountBean addDiscount(DiscountBean discount) throws DiscountDateExceedException;
	DiscountBean viewDiscountById(String discountId) throws DiscountDateExceedException;
	List<DiscountBean> findAllDiscounts()throws DiscountDateExceedException;
}
