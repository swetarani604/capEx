package com.cg.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.bean.OrderBean;
import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.exception.ProductNotFoundException;
import com.cg.capstore.repo.ReturnGoodsRepo;

@Service
public class ReturnGoodsServiceImpl implements IReturnGoodsService {

	@Autowired
	ReturnGoodsRepo returnGoodsRepo;

	@Override
	public OrderBean returnProduct(String order) throws ProductNotFoundException {
		OrderBean orderBean;
		
			orderBean = returnGoodsRepo.getOne(order);
			if (orderBean.getOrderStatus().equalsIgnoreCase("Delivered")) {
				orderBean.setOrderStatus("Returned");

				List<ProductBean> returningProcess = orderBean.getProduct();

				for (ProductBean productBean : returningProcess) {

					int quantity = productBean.getQuantity() + orderBean.getQuantity();
					productBean.setQuantity(quantity);

				}

			
		} else {
			throw new ProductNotFoundException("Order Not delivered yet");
		}

		return returnGoodsRepo.save(orderBean);

	}

	@Override
	public String getDeliveryStatus(String orderId) throws ProductNotFoundException {
		OrderBean oDetails = returnGoodsRepo.getOne(orderId);

		if (orderId == null) {
			throw new ProductNotFoundException("Invalid OrderId");
		}
		String status = oDetails.getOrderStatus();
		return status;
	}

}
