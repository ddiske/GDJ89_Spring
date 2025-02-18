package com.root.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
//	list
	public List<ProductDTO> getList() throws Exception {
		List<ProductDTO> ar = productDAO.getList();
		
		return ar;
	}
	
//	add
	public int add(ProductDTO productDTO) throws Exception {
//		DAO 호출 코드
		int result = productDAO.add(productDTO);
		
		return result;
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		
		productDTO = productDAO.getDetail(productDTO);
		
		return productDTO;
	}
	

}
