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
		
		// TotalPage 계산
		Long totalPage = totalCount/10;
		if(totalCount % 10 != 0) {
			totalPage++;
		}
		
		// TotalBlock
		Long totalBlock = totalPage / 5;
		if(totalPage/5 != 0) {
			totalBlock++;
		}
		
		// Page 번호로 Block 계산
		Long curBlock = (pager.getPage() + 4) / 5;
		
		// curBlock으로 시작번호와 끝번호 계산
		Long startBlock = (curBlock-1)*5 + 1;
		Long endBlock = curBlock*5;
		
		pager.setTotalPage(totalPage);
		pager.setStartBlock(startBlock);
		pager.setEndBlock(endBlock);
		pager.makeNum();
		
		if(totalBlock == curBlock) {
			pager.setEndBlock(totalPage);
			pager.setEndCheck(true);
		}
		
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
