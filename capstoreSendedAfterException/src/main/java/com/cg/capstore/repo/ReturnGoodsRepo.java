package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.capstore.bean.OrderBean;

@Repository
public interface ReturnGoodsRepo extends JpaRepository<OrderBean, String> {

}
