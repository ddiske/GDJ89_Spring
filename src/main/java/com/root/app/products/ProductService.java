package com.root.app.products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		Long totalCount = productDAO.getTotalCount(pager);
		
		pager.make(totalCount);
		
		
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
	
//	---------- Comments ----------------
	
	public int addComments(CommentsDTO commentsDTO) throws Exception {
		return productDAO.addComments(commentsDTO);
	}
	
	public List<CommentsDTO> getCommentsList(ProductDTO productDTO, Pager pager) throws Exception {
		CommentsDTO commentsDTO = new CommentsDTO();
		commentsDTO.setProductNum(productDTO.getProductNum());
		
		Long totalCount = productDAO.getCommentsTotal(productDTO);
		
		pager.setPerPage(5L);
		pager.make(totalCount);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		map.put("commentsDTO", commentsDTO);
		
		return productDAO.getCommentsList(map);
	}

}
