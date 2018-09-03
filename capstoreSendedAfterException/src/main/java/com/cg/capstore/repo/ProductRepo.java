package com.cg.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.capstore.bean.ProductBean;

@Repository
public interface ProductRepo extends JpaRepository<ProductBean, String>{
	
	@Query("select distinct p.category from ProductBean p")
	public List<ProductBean> getSimilarCategory();

}
