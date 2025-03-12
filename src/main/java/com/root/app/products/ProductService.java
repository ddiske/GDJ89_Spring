package com.root.app.products;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.root.app.boards.BoardFileDTO;
import com.root.app.files.FileDAO;
import com.root.app.pages.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private FileDAO fileDAO;
	
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
	
	public String fileSave(MultipartFile uploadFile, ServletContext servletContext)throws Exception{
		//1. 어디에 저장할 것인가??
		String path = servletContext.getRealPath("/resources/images/products/");
		
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2. HDD에 파일을 저장하고 저장된 파일명을 리턴
		String fileName = fileDAO.upload(path, uploadFile);
		
		
		return fileName;
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
	
	public List<CommentsDTO> getCommentsList(CommentsDTO commentsDTO, Pager pager) throws Exception {
		commentsDTO.setProductNum(commentsDTO.getProductNum());
		
		Long totalCount = productDAO.getCommentsTotal(commentsDTO);
		pager.setPerPage(5L);
		pager.make(totalCount);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		map.put("commentsDTO", commentsDTO);
		
		return productDAO.getCommentsList(map);
	}
	
	public int deleteComments(CommentsDTO commentsDTO) throws Exception {
		return productDAO.deleteComments(commentsDTO);
	}
	
	public int updateComments(CommentsDTO commentsDTO) throws Exception {
		return productDAO.updateComments(commentsDTO);
	}

}
