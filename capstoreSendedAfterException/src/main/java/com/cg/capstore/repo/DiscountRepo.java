package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capstore.bean.DiscountBean;

public interface DiscountRepo extends JpaRepository<DiscountBean, String>{

}
