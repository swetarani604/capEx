package com.cg.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.capstore.bean.PromosBean;
import com.cg.capstore.exception.PromoCodeInvalidException;
import com.cg.capstore.repo.PromoRepository;

@Component(value="promoServices")
public class PromoServiceImpl implements PromoDisplayService{
	@Autowired
	PromoRepository promo;

	@Override
	public String addPromo(PromosBean promoss) throws PromoCodeInvalidException {
		
		if(promoss.getPromoCode()==null) {
			throw new PromoCodeInvalidException("PromoCode is Not Valid");
		}
		else {
		promo.save(promoss);
		return promoss.getPromoCode()+" is added ";
	}}

	@Override
	public PromosBean viewById(String pId) throws PromoCodeInvalidException{
		if(pId==null) {
			throw new PromoCodeInvalidException("Promo code is not a valid one");
		}else
		return promo.getOne(pId);
	}

	@Override
	public List<PromosBean> viewAllPromos() throws PromoCodeInvalidException {
		if(PromosBean.class==null) {
			throw new PromoCodeInvalidException("No Promos Available");
		}
		else
		return promo.findAll();
	}
	
	

}
