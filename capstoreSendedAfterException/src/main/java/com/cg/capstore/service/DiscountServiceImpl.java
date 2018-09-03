package com.cg.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.capstore.bean.DiscountBean;
import com.cg.capstore.exception.DiscountDateExceedException;
import com.cg.capstore.repo.DiscountRepo;

@Service
public class DiscountServiceImpl implements IDiscountService {
	
	@Autowired
	DiscountRepo repo;

	@Override
	public DiscountBean discountDB(DiscountBean discount) throws DiscountDateExceedException {		
		if(discount.getDiscountId()!=null) {
			throw new DiscountDateExceedException("Discount id already exist");
		}
		return repo.save(discount);
	}
	
	@Override
	public DiscountBean viewDiscountById(String discountId) throws DiscountDateExceedException {
		if(discountId==null) {
			throw new DiscountDateExceedException("Invalid Discount id ");
		}
		return repo.getOne(discountId);
	}

}


