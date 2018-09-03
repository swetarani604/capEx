package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capstore.bean.MerchantBean;

public interface MerchantRepo extends JpaRepository<MerchantBean, String>{

}
