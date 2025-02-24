package com.root.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.app.pages.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
//	list
	public List<ProductDTO> getList(Pager pager) throws Exception {
//		Pager pager = new Pager();
//		pager.setPage(page);
		
		Long totalCount = productDAO.getTotalCount();
		Long totalPage = totalCount/10;
		
		if(totalCount % 10 != 0) {
			totalPage++;
		}
		
		pager.setTotalPage(totalPage);
		
		pager.makeNum();
		return productDAO.getList(pager);
		
	}
	
//	add
	public int add(ProductDTO productDTO) throws Exception {
//		DAO 호출 코드
		return productDAO.add(productDTO);
		
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		
		return productDAO.getDetail(productDTO);
		
	}
	
	
	public int update (ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
		
	}
	
	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}

}
