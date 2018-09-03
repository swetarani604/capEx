package com.cg.capstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.capstore.bean.DiscountBean;
import com.cg.capstore.exception.DiscountDateExceedException;
import com.cg.capstore.service.ApplyDiscountInterface;

@RestController
public class ControllerDiscount {

	@Autowired
	ApplyDiscountInterface service;

	@RequestMapping(value = "/addDiscount", method = RequestMethod.POST)
	public DiscountBean addDiscount(@RequestBody DiscountBean discount) throws DiscountDateExceedException {
		try {
			return service.addDiscount(discount);
		} catch (DiscountDateExceedException e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/viewById", method = RequestMethod.GET)
	public DiscountBean viewDiscountById(String discountId) throws DiscountDateExceedException {
		try {
			return service.viewDiscountById(discountId);
		} catch (DiscountDateExceedException e) {
throw e;
		}	
	}
	
	@RequestMapping(value = "/viewAll", method = RequestMethod.GET)
	public List<DiscountBean> findAllDiscounts() throws DiscountDateExceedException{
		try {
			return service.findAllDiscounts();
		} catch (DiscountDateExceedException e) {
			throw e;
		}	
	}
}
