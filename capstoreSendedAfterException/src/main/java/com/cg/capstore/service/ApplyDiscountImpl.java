package com.cg.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.capstore.bean.DiscountBean;
import com.cg.capstore.exception.DiscountDateExceedException;
import com.cg.capstore.repo.DiscountRepo;

@Service
public class ApplyDiscountImpl implements ApplyDiscountInterface {
	@Autowired
	DiscountRepo repo;

	@Override
	public DiscountBean addDiscount(DiscountBean discount) throws DiscountDateExceedException {
		if(discount.getDiscountId()!= null) {
			throw new DiscountDateExceedException("Discount is already available");
		}else {
		return repo.save(discount);
		}
	}

	@Override
	public DiscountBean viewDiscountById(String discountId) throws DiscountDateExceedException {
		if(discountId==null) {
			throw new DiscountDateExceedException("Discount Id is not available");
		}
		
		return repo.getOne(discountId);
	}

	@Override
	public List<DiscountBean> findAllDiscounts() throws DiscountDateExceedException {
		if(DiscountBean.class== null) {
			throw new DiscountDateExceedException("Discount is not available");
		}else {
		return repo.findAll();
	}
	}
}
