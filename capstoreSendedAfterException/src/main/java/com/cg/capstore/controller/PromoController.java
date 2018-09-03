package com.cg.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.capstore.bean.PromosBean;
import com.cg.capstore.exception.PromoCodeInvalidException;
import com.cg.capstore.service.PromoDisplayService;

@RestController
public class PromoController {

	@Autowired
	PromoDisplayService service;
	
	@RequestMapping(value = "/addpromo", method = RequestMethod.POST)
	public String promoDb(@RequestBody PromosBean promoss) throws PromoCodeInvalidException {
		System.err.println("Back"+promoss.toString());
		try {
			return service.addPromo(promoss);
		} catch (PromoCodeInvalidException e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/viewPromoById", method = RequestMethod.GET)
	public PromosBean viewById(PromosBean pId) throws PromoCodeInvalidException {
		//System.out.println(pId.getPromoCode());
		try {
			return service.viewById(pId.getPromoCode());
		} catch (PromoCodeInvalidException e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/viewAllPromos", method = RequestMethod.GET)
	public List<PromosBean> viewAllPromos() throws PromoCodeInvalidException{
		try {
			return service.viewAllPromos();
		} catch (PromoCodeInvalidException e) {
			throw e;
		}
	}
}
