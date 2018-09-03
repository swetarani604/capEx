package com.cg.capstore.service;

import java.util.List;

import com.cg.capstore.bean.PromosBean;
import com.cg.capstore.exception.PromoCodeInvalidException;

public interface PromoDisplayService {

	String addPromo(PromosBean promoss) throws PromoCodeInvalidException ;
	PromosBean viewById(String pId) throws PromoCodeInvalidException;
	List<PromosBean> viewAllPromos() throws PromoCodeInvalidException;
}
