package com.cg.capstore.service;

import com.cg.capstore.bean.DiscountBean;
import com.cg.capstore.exception.DiscountDateExceedException;

public interface IDiscountService {

	DiscountBean discountDB(DiscountBean discount) throws DiscountDateExceedException;
	public DiscountBean viewDiscountById(String discountId)throws DiscountDateExceedException;

}
