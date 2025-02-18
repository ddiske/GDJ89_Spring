package com.root.app.products;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository

public class ProductDAO {
	
//	list
	public List<ProductDTO> getList()throws Exception {
		System.out.println("DAO List");
		
		return null;
	}
	

}
